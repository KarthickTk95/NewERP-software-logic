package com.ERPsoftware.newERP.Service;

import com.ERPsoftware.newERP.Model.RawData;
import com.ERPsoftware.newERP.Model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<RawData> getAllRecords() {
        String sql = "SELECT * FROM NewERPdata.raw_data_table";
        List<RawData> records = jdbcTemplate.query(sql, (rs, rowNum) -> {
            RawData record = new RawData();
            record.setId(rs.getLong("id"));
            record.setEid(rs.getLong("eid"));
            record.setDirection(rs.getString("direction"));
            record.setCaptureTime(rs.getString("captureTime")); // Assuming captureTime is of type TIMESTAMP or DATETIME
            record.setStatus(rs.getInt("status"));
            record.setCaptureDevice(rs.getString("captureDevice"));
            return record;
        });
        return records;
    }

    public List<Shift> getAllShiftRecords() {
        String sql = "SELECT * FROM NewERPdata.shift_table";
        List<Shift> shiftrecords = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Shift record = new Shift();
            record.setId(rs.getLong("id"));
            record.setSid(rs.getLong("sid"));
            record.setIn_time(rs.getString("in_time"));
            record.setOut_time(rs.getString("out_time"));
            record.setShiftName(rs.getString("shiftName"));
            return record;
        });

        return shiftrecords;
    }
}
