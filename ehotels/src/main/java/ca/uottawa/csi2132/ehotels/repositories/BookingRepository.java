package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert booking only (separate from books table)
    public Long insertBooking(Booking booking) {
        String sql = "INSERT INTO booking (status, booking_date, check_in_date, check_out_date) VALUES (?, ?, ?, ?) RETURNING booking_ID";
        return jdbcTemplate.queryForObject(sql, new Object[]{
                booking.getStatus(),
                Date.valueOf(booking.getBookingDate()),
                booking.getCheckInDate() != null ? Date.valueOf(booking.getCheckInDate()) : null,
                booking.getCheckOutDate() != null ? Date.valueOf(booking.getCheckOutDate()) : null
        }, Long.class);
    }

    // Link booking ↔ customer ↔ room in `books` table
    public void linkBooking(Long bookingId, Long customerId, Long roomId) {
        String sql = "INSERT INTO books (booking_ID, customer_ID, room_ID) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bookingId, customerId, roomId);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM booking";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Booking(
                rs.getLong("booking_ID"),
                rs.getString("status"),
                rs.getDate("booking_date").toLocalDate(),
                rs.getDate("check_in_date") != null ? rs.getDate("check_in_date").toLocalDate() : null,
                rs.getDate("check_out_date") != null ? rs.getDate("check_out_date").toLocalDate() : null
        ));
    }

    // Update booking (e.g., change status or dates)
    public void updateBooking(Long id, Booking booking) {
        String sql = "UPDATE booking SET status = ?, booking_date = ?, check_in_date = ?, check_out_date = ? WHERE booking_ID = ?";
        jdbcTemplate.update(sql,
                booking.getStatus(),
                Date.valueOf(booking.getBookingDate()),
                booking.getCheckInDate() != null ? Date.valueOf(booking.getCheckInDate()) : null,
                booking.getCheckOutDate() != null ? Date.valueOf(booking.getCheckOutDate()) : null,
                id);
    }

    // Delete booking
    public void deleteBooking(Long id) {
        String sql = "DELETE FROM booking WHERE booking_ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
