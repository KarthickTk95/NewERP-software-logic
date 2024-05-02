package com.ERPsoftware.newERP.Service;

import com.ERPsoftware.newERP.Model.MergedTableInShift;
import com.ERPsoftware.newERP.Model.RawData;
import com.ERPsoftware.newERP.Model.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class MergedTableService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   /* public void insertIntoMergedTable() {
        String sql = "INSERT INTO merged_table (eid, direction_in, captureTime_in, status_in, capturedevice_in, direction_out, captureTime_out, status_out, capturedevice_out) " +
                "SELECT t1.eid, t1.direction AS direction_in, t1.capture_time AS captureTime_in, t1.status AS status_in, t1.capture_device AS capturedevice_in, " +
                "t2.direction AS direction_out, t2.capture_time AS captureTime_out, t2.status AS status_out, t2.capture_device AS capturedevice_out " +
                "FROM in_data t1 " +
                "JOIN out_data t2 ON t1.eid = t2.eid AND t1.id = t2.id";

        jdbcTemplate.update(sql);
    }*/

    public boolean insertIntoMergedTable() {
        String sql = "INSERT INTO merged_table (employeeid, punchedtime_in, punchtype_in, ipaddr_in, punchedtime_out, punchtype_out, ipaddr_out) " +
                "select t1.employeeid as employeeid,t1.punchedtime as punchedtime_in,t1.punchtype as punchtype_in,t1.ipaddr as ipaddr_in,t2.punchedtime as punchedtime_out,t2.punchtype as punchtype_out,t2.ipaddr as ipaddr_out from punchedin t1 join punchedout t2 on t1.employeeid = t2.employeeid ;";

        int rowsAffected = jdbcTemplate.update(sql);

        return rowsAffected > 0; // Return true if at least one row was affected by the update
    }



    public void insertShiftData() throws DataAccessException {

        String selectSql = "SELECT id,punchedtime_in, punchedtime_out FROM merged_table";
        List<MergedTableInShift> mergedDataList = jdbcTemplate.query(selectSql, (rs, rowNum) -> {
            MergedTableInShift mergedData = new MergedTableInShift();
            mergedData.setId(rs.getLong("id"));
            mergedData.setPunchedtime_in(rs.getString("punchedtime_in"));
            mergedData.setPunchedtime_out(rs.getString("punchedtime_out"));
            return mergedData;
        });

        // Select data from raw_data_table where direction is 'in'
        String selectSql1 = "SELECT id, sid, shiftname, in_time, out_time FROM shift_table";
        List<Shift> shiftList = jdbcTemplate.query(selectSql1, (rs, rowNum) -> {
            Shift shift = new Shift();
            shift.setId(rs.getLong("id"));
            shift.setIn_time(rs.getString("in_time"));
            shift.setOut_time(rs.getString("out_time"));
            shift.setShiftName(rs.getString("shiftname"));
            return shift;
        });

        // Iterate through the shift list
        for (Shift shift : shiftList) {
            // Compare captureTime_in and captureTime_out with the shift timings
            for (MergedTableInShift  mergedData : mergedDataList) {
                LocalTime captureTimeIn = LocalTime.parse(mergedData.getPunchedtime_in().substring(11)); // Extract time part
                LocalTime captureTimeOut = LocalTime.parse(mergedData.getPunchedtime_out().substring(11)); // Extract time part

                // Check if captureTime_in falls within the shift timings
                if (captureTimeIn.compareTo(LocalTime.parse(shift.getIn_time())) >= 0 &&
                        captureTimeIn.compareTo(LocalTime.parse(shift.getOut_time())) < 0) {
                    // Insert shift details into merged_tableinshift
                    String updateSql = "UPDATE merged_table " +
                            "SET in_time = ?, out_time = ?, shiftname = ? " +
                            "WHERE id = ?";

                    jdbcTemplate.update(updateSql,
                            shift.getIn_time(),
                            shift.getOut_time(),
                            shift.getShiftName(),
                            mergedData.getId()
                    );
                }

                // Similar logic can be applied for captureTime_out if needed
            }
        }
    }


}
