package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Hotel;
import ca.uottawa.csi2132.ehotels.entities.HotelEmail;
import ca.uottawa.csi2132.ehotels.entities.HotelPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Repository
public class HotelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create hotel
    public void insertHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel (hotel_chain_ID, rating, num_of_rooms, address) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, hotel.getHotelChainId(), hotel.getRating(), hotel.getNumOfRooms(), hotel.getAddress());
    }

    // Add phone number to hotel
    public void addPhone(Long hotelId, String phone) {
        String sql = "INSERT INTO hotel_phone (hotel_ID, phone) VALUES (?, ?)";
        jdbcTemplate.update(sql, hotelId, phone);
    }

    // Add email to hotel
    public void addEmail(Long hotelId, String email) {
        String sql = "INSERT INTO hotel_email (hotel_ID, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, hotelId, email);
    }

    // Get all phones for hotel
    public List<String> getHotelPhones(Long hotelId) {
        String sql = "SELECT phone FROM hotel_phone WHERE hotel_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{hotelId}, String.class);
    }

    // Get all emails for hotel
    public List<String> getHotelEmails(Long hotelId) {
        String sql = "SELECT email FROM hotel_email WHERE hotel_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{hotelId}, String.class);
    }


    // Update a hotel
    public void update(Hotel hotel) {
        String sql = """
            UPDATE hotel
            SET hotel_chain_id = ?, rating = ?, num_of_rooms = ?, address = ?
            WHERE hotel_id = ?
        """;
        jdbcTemplate.update(
            sql,
            hotel.getHotelChainId(),
            hotel.getRating(),
            hotel.getNumOfRooms(),
            hotel.getAddress(),
            hotel.getHotelId()
        );
    }

    // Delete a hotel by ID
    public void deleteById(Long hotelId) {
        String sql = "DELETE FROM hotel WHERE hotel_id = ?";
        jdbcTemplate.update(sql, hotelId);
    }

    // Maps each SQL row to a Hotel object
    private static class HotelRowMapper implements RowMapper<Hotel> {
        @Override
        public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hotel hotel = new Hotel();
            hotel.setHotelId(rs.getLong("hotel_id"));
            hotel.setHotelChainId(rs.getLong("hotel_chain_id"));
            hotel.setRating(rs.getShort("rating"));
            hotel.setNumOfRooms(rs.getInt("num_of_rooms"));
            hotel.setAddress(rs.getString("address"));
            return hotel;
        }
    }
}
