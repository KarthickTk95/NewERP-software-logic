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
        String sql = "SELECT * FROM NewERPdata.raw_data_table";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RawData record = new RawData();
            record.setId(rs.getLong("id"));
            record.setEid(rs.getLong("eid"));
            record.setDirection(rs.getString("direction"));
            record.setCaptureTime(rs.getString("captureTime")); // Assuming captureTime is of type TIMESTAMP or DATETIME
            record.setStatus(rs.getInt("status"));
            record.setCaptureDevice(rs.getString("captureDevice"));
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


    public void insertCombinedData() throws DataAccessException {
        // Select data from raw_data_table where direction is 'in'
        String selectSql = "SELECT id, Eid, direction, captureTime, capturedevice FROM NewERPdata.raw_data_table WHERE direction = 'in'";
        List<RawData> rawDataList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            RawData rawData = new RawData();
            rawData.setId(rs.getLong("id"));
            rawData.setEid(rs.getLong("Eid"));
            rawData.setDirection(rs.getString("direction"));
            rawData.setCaptureTime(rs.getString("captureTime"));
            rawData.setCaptureDevice(rs.getString("capturedevice"));
            return rawData;
        });

        // Insert selected data into combined_table
        String insertSql = "INSERT INTO NewERPdata.combined_table (id, Eid, in_direction, incapture_time, outcapture_time, in_capturedevice, out_direction, out_captureTime, out_capturedevice, sid, in_time, out_time, shiftname) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        for (RawData rawData : rawDataList) {
            jdbcTemplate.update(insertSql,
                    rawData.getId(),
                    rawData.getEid(),
                    rawData.getDirection(),
                    rawData.getCaptureTime(),
                    null, // Replace with actual value
                    rawData.getCaptureDevice(), // Replace with actual value
                    null, // Replace with actual value
                    null, // Replace with actual value
                    null, // Replace with actual value
                    null, // Replace with actual value
                    null, // Replace with actual value
                    null, // Replace with actual value
                    null  // Replace with actual value
            );
        }
    }

    public void updateCombinedData() throws DataAccessException {
        // Select data from raw_data_table where direction is 'out'
        String selectSql = "SELECT id, Eid, direction, captureTime, capturedevice FROM NewERPdata.raw_data_table WHERE direction = 'out'";
        List<RawData> rawDataList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            RawData rawData = new RawData();
            rawData.setId(rs.getLong("id"));
            rawData.setEid(rs.getLong("Eid"));
            rawData.setDirection(rs.getString("direction"));
            rawData.setCaptureTime(rs.getString("captureTime"));
            rawData.setCaptureDevice(rs.getString("capturedevice"));
            return rawData;
        });

        // Update selected data in combined_table
        String updateSql = "UPDATE `NewERPdata`.`combined_table` SET `outcapture_time` = ?, `out_direction` = ?, `out_capturedevice` = ? WHERE `Eid` = ? AND outcapture_time IS NULL AND out_direction IS NULL AND out_capturedevice IS NULL";
        for (RawData rawData : rawDataList) {
            jdbcTemplate.update(updateSql,
                    rawData.getCaptureTime(),
                    rawData.getDirection(),
                    rawData.getCaptureDevice(),
                    rawData.getEid()
            );
        }
    }

    public void insertInData() throws DataAccessException {
        // Select data from raw_data_table where direction is 'in'
        String selectSql = "SELECT id, Eid, direction, captureTime, capturedevice FROM NewERPdata.raw_data_table WHERE direction = 'in'";
        List<RawData> rawDataList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            RawData rawData = new RawData();
            rawData.setId(rs.getLong("id"));
            rawData.setEid(rs.getLong("Eid"));
            rawData.setDirection(rs.getString("direction"));
            rawData.setCaptureTime(rs.getString("captureTime"));
            rawData.setCaptureDevice(rs.getString("capturedevice"));
            return rawData;
        });

        // Insert selected data into combined_table
        String insertSql = "INSERT INTO NewERPdata.in_data ( Eid, capture_device, capture_time, direction, status) VALUES (?, ?, ?, ?, ?)";
        for (RawData rawData : rawDataList) {
            jdbcTemplate.update(insertSql,
                    rawData.getEid(),
                    rawData.getCaptureDevice(),
                    rawData.getCaptureTime(),
                    rawData.getDirection(),
                    rawData.getStatus()

            );
        }
    }

    public void insertOutData() throws DataAccessException {
        // Select data from raw_data_table where direction is 'in'
        String selectSql = "SELECT id, Eid, direction, captureTime, capturedevice FROM NewERPdata.raw_data_table WHERE direction = 'out'";
        List<RawData> rawDataList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            RawData rawData = new RawData();
            rawData.setId(rs.getLong("id"));
            rawData.setEid(rs.getLong("Eid"));
            rawData.setDirection(rs.getString("direction"));
            rawData.setCaptureTime(rs.getString("captureTime"));
            rawData.setCaptureDevice(rs.getString("capturedevice"));
            return rawData;
        });

        // Insert selected data into combined_table
        String insertSql = "INSERT INTO NewERPdata.out_data ( Eid, capture_device, capture_time, direction, status) VALUES (?, ?, ?, ?, ?)";
        for (RawData rawData : rawDataList) {
            jdbcTemplate.update(insertSql,
                    rawData.getEid(),
                    rawData.getCaptureDevice(),
                    rawData.getCaptureTime(),
                    rawData.getDirection(),
                    rawData.getStatus()

            );
        }
    }

}


