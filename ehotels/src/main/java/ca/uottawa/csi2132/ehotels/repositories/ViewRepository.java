package ca.uottawa.csi2132.ehotels.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ViewRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // View 1: Available rooms per area (hotel address)
    public List<Map<String, Object>> getAvailableRoomsPerArea() {
        String sql = "SELECT * FROM available_rooms_per_area";
        return jdbcTemplate.queryForList(sql);
    }

    // View 2: Aggregated capacity of rooms per hotel
    public List<Map<String, Object>> getAggregatedRoomCapacity() {
        String sql = "SELECT * FROM aggregated_room_capacity";
        return jdbcTemplate.queryForList(sql);
    }
}
