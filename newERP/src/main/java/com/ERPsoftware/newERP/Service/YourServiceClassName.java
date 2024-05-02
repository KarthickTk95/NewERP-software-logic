package com.ERPsoftware.newERP.Service;

import com.ERPsoftware.newERP.Model.DataResponse;
import com.ERPsoftware.newERP.Model.RawData;
import com.ERPsoftware.newERP.Model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class YourServiceClassName {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DataResponse getAllData() {
        List<RawData> rawRecords = getAllRawData();
        List<Shift> shiftRecords = getAllShiftData();

        return new DataResponse(rawRecords, shiftRecords);
    }

    private List<RawData> getAllRawData() {
        String sql = "SELECT * FROM NewSchema.punchedtime";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RawData record = new RawData();
            record.setId(rs.getLong("id"));
            record.setEmployeeid(rs.getLong("employeeid"));
            record.setIsoutpunch(rs.getString("isoutpunch"));
            record.setPunchedtime(rs.getString("punchedtime"));
            record.setProcessed(rs.getInt("processed"));
            record.setPunchtype(rs.getString("punchtype"));
            record.setIpaddr(rs.getString("ipaddr"));
            return record;
        });
    }

    private List<Shift> getAllShiftData() {
        String sql = "SELECT * FROM NewERPdata.shift_table";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Shift record = new Shift();
            record.setId(rs.getLong("id"));
            record.setSid(rs.getLong("sid"));
            record.setIn_time(rs.getString("in_time"));
            record.setOut_time(rs.getString("out_time"));
            record.setShiftName(rs.getString("shiftName"));
            return record;
        });
    }




    public void insertInData() throws DataAccessException {
        // Select data from raw_data_table where direction is 'in'
        String selectSql = "select id, punchedtime, employeeid, isoutpunch, processed, punchtype, ipaddr from punchedtime where isoutpunch = 0;";
        List<RawData> rawDataList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            RawData rawData = new RawData();
            rawData.setId(rs.getLong("id"));
            rawData.setEmployeeid(rs.getLong("employeeid"));
            rawData.setIsoutpunch(rs.getString("isoutpunch"));
            rawData.setPunchedtime(rs.getString("punchedtime"));
            rawData.setProcessed(rs.getInt("processed"));
            rawData.setPunchtype(rs.getString("punchtype"));
            rawData.setIpaddr(rs.getString("ipaddr"));
            return rawData;
        });

        // Insert selected data into combined_table
        String insertSql = "INSERT INTO NewSchema.punchedin (punchedtime, employeeid, isoutpunch, processed, punchtype, ipaddr) VALUES (?, ?, ?, ?, ?,?)";
        for (RawData rawData : rawDataList) {
            jdbcTemplate.update(insertSql,
                    rawData.getPunchedtime(),
                    rawData.getEmployeeid(),
                    rawData.getIsoutpunch(),
                    rawData.getProcessed(),
                    rawData.getPunchtype(),
                    rawData.getIpaddr()

            );
        }
    }

    public void insertOutData() throws DataAccessException {
        // Select data from raw_data_table where direction is 'in'
        String selectSql = "select id, punchedtime, employeeid, isoutpunch, processed, punchtype, ipaddr from punchedtime where isoutpunch = 1;";
        List<RawData> rawDataList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            RawData rawData = new RawData();
            rawData.setId(rs.getLong("id"));
            rawData.setEmployeeid(rs.getLong("employeeid"));
            rawData.setIsoutpunch(rs.getString("isoutpunch"));
            rawData.setProcessed(rs.getInt("processed"));
            rawData.setPunchedtime(rs.getString("punchedtime"));
            rawData.setPunchtype(rs.getString("punchtype"));
            rawData.setIpaddr(rs.getString("ipaddr"));
            return rawData;
        });

        // Insert selected data into combined_table
        String insertSql = "INSERT INTO NewSchema.punchedout (punchedtime, employeeid, isoutpunch, processed, punchtype, ipaddr) VALUES (?, ?, ?, ?, ?,?)";
        for (RawData rawData : rawDataList) {
            jdbcTemplate.update(insertSql,
                    rawData.getPunchedtime(),
                    rawData.getEmployeeid(),
                    rawData.getIsoutpunch(),
                    rawData.getProcessed(),
                    rawData.getPunchtype(),
                    rawData.getIpaddr()

            );
        }
    }

}


