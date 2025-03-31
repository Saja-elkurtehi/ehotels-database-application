package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert booking with customer_ID and room_ID included
    public Long insertBooking(Booking booking) {
        String sql = "INSERT INTO booking (customer_ID, room_ID, status, booking_date, check_in_date, check_out_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?) RETURNING booking_ID";
        return jdbcTemplate.queryForObject(sql, new Object[] {
                booking.getCustomerId(),
                booking.getRoomId(),
                booking.getStatus(),
                Date.valueOf(booking.getBookingDate()),
                booking.getCheckInDate() != null ? Date.valueOf(booking.getCheckInDate()) : null,
                booking.getCheckOutDate() != null ? Date.valueOf(booking.getCheckOutDate()) : null
        }, Long.class);
    }

    // Insert record into books table to link booking, customer, and room
    public void linkBooking(Long bookingId, Long customerId, Long roomId) {
        String sql = "INSERT INTO books (booking_ID, customer_ID, room_ID) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bookingId, customerId, roomId);
    }
    public List<Booking> getOverlappingBookings(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        String sql = "SELECT * FROM booking " +
                     "WHERE room_ID = ? " +
                     "AND check_in_date < ? " +
                     "AND check_out_date > ?";
        return jdbcTemplate.query(sql, new Object[] { 
            roomId, 
            Date.valueOf(checkOut),  // compare with requested checkOutDate
            Date.valueOf(checkIn)    // compare with requested checkInDate
        }, (rs, rowNum) -> new Booking(
                rs.getLong("booking_ID"),
                rs.getLong("customer_ID"),
                rs.getLong("room_ID"),
                rs.getString("status"),
                rs.getDate("booking_date").toLocalDate(),
                rs.getDate("check_in_date") != null ? rs.getDate("check_in_date").toLocalDate() : null,
                rs.getDate("check_out_date") != null ? rs.getDate("check_out_date").toLocalDate() : null
        ));
    }
    

    // Get all bookings
    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM booking";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Booking(
                rs.getLong("booking_ID"),
                rs.getLong("customer_ID"),
                rs.getLong("room_ID"),
                rs.getString("status"),
                rs.getDate("booking_date").toLocalDate(),
                rs.getDate("check_in_date") != null ? rs.getDate("check_in_date").toLocalDate() : null,
                rs.getDate("check_out_date") != null ? rs.getDate("check_out_date").toLocalDate() : null
        ));
    }

    // Update booking (for example, updating status or dates)
    public void updateBooking(Long id, Booking booking) {
        String sql = "UPDATE booking SET status = ?, booking_date = ?, check_in_date = ?, check_out_date = ? " +
                     "WHERE booking_ID = ?";
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
