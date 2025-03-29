package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Renting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class RentingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert a new renting
    public void insertRenting(Renting renting) {
        String sql = "INSERT INTO renting (check_in_date, check_out_date, status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                Date.valueOf(renting.getCheckInDate()),
                renting.getCheckOutDate() != null ? Date.valueOf(renting.getCheckOutDate()) : null,
                renting.getStatus());
    }

    // Get all rentings
    public List<Renting> getAllRentings() {
        String sql = "SELECT * FROM renting";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Renting(
                rs.getLong("renting_ID"),
                rs.getLong("customer_ID"),
                rs.getLong("room_ID"),
                rs.getLong("employee_ID"),
                rs.getDate("check_in_date").toLocalDate(),
                rs.getDate("check_out_date") != null ? rs.getDate("check_out_date").toLocalDate() : null,
                rs.getString("status")));
    }

    // Get renting by ID
    public Renting getRentingById(Long id) {
        String sql = "SELECT * FROM renting WHERE renting_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rowNum) -> new Renting(
                rs.getLong("renting_ID"),
                rs.getLong("customer_ID"),
                rs.getLong("room_ID"),
                rs.getLong("employee_ID"),
                rs.getDate("check_in_date").toLocalDate(),
                rs.getDate("check_out_date") != null ? rs.getDate("check_out_date").toLocalDate() : null,
                rs.getString("status")));
    }

    // Update renting info (e.g. set check-out date or status)
    public void updateRenting(Long id, Renting renting) {
        String sql = "UPDATE renting SET check_in_date = ?, check_out_date = ?, status = ? WHERE renting_ID = ?";
        jdbcTemplate.update(sql,
                Date.valueOf(renting.getCheckInDate()),
                renting.getCheckOutDate() != null ? Date.valueOf(renting.getCheckOutDate()) : null,
                renting.getStatus(),
                id);
    }

    // Delete a renting (if needed)
    public void deleteRenting(Long id) {
        String sql = "DELETE FROM renting WHERE renting_ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
