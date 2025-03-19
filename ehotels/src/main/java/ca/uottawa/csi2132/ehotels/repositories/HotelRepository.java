package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class HotelRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 1) CREATE / INSERT
    public void save(Hotel hotel) {
        String sql = "INSERT INTO hotel (hotel_chain_id, rating, num_of_rooms, address) "
                   + "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
            sql,
            hotel.getHotelChainId(),
            hotel.getRating(),
            hotel.getNumOfRooms(),
            hotel.getAddress()
        );
    }

    // 2) READ ALL
    public List<Hotel> findAll() {
        String sql = "SELECT hotel_id, hotel_chain_id, rating, num_of_rooms, address FROM hotel";
        return jdbcTemplate.query(sql, new HotelRowMapper());
    }

    // 3) READ ONE (by ID)
    public Optional<Hotel> findById(Long hotelId) {
        String sql = "SELECT hotel_id, hotel_chain_id, rating, num_of_rooms, address "
                   + "FROM hotel WHERE hotel_id = ?";
        List<Hotel> results = jdbcTemplate.query(sql, new HotelRowMapper(), hotelId);
        if (results.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(results.get(0));
    }

    // 4) UPDATE
    public void update(Hotel hotel) {
        String sql = "UPDATE hotel "
                   + "SET hotel_chain_id = ?, rating = ?, num_of_rooms = ?, address = ? "
                   + "WHERE hotel_id = ?";
        jdbcTemplate.update(
            sql,
            hotel.getHotelChainId(),
            hotel.getRating(),
            hotel.getNumOfRooms(),
            hotel.getAddress(),
            hotel.getHotelId()
        );
    }

    // 5) DELETE
    public void deleteById(Long hotelId) {
        String sql = "DELETE FROM hotel WHERE hotel_id = ?";
        jdbcTemplate.update(sql, hotelId);
    }

    // RowMapper to map SQL rows to Java objects
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
