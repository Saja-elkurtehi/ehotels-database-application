package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.HotelChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelChainRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert a new hotel chain
    public void insertHotelChain(HotelChain hotelChain) {
        String sql = "INSERT INTO hotel_chain (num_of_hotels, address) VALUES (?, ?)";
        jdbcTemplate.update(sql, hotelChain.getNumOfHotels(), hotelChain.getAddress());
    }

    // Retrieve all hotel chains
    public List<HotelChain> getAllHotelChains() {
        String sql = "SELECT * FROM hotel_chain";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new HotelChain(
                rs.getLong("hotel_chain_ID"),
                rs.getInt("num_of_hotels"),
                rs.getString("address")
        ));
    }

    // Retrieve a single hotel chain by ID
    public HotelChain getHotelChainById(Long id) {
        String sql = "SELECT * FROM hotel_chain WHERE hotel_chain_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new HotelChain(
                rs.getLong("hotel_chain_ID"),
                rs.getInt("num_of_hotels"),
                rs.getString("address")
        ));
    }

    // Update a hotel chain by ID
    public void updateHotelChain(Long id, HotelChain hotelChain) {
        String sql = "UPDATE hotel_chain SET num_of_hotels = ?, address = ? WHERE hotel_chain_ID = ?";
        jdbcTemplate.update(sql, hotelChain.getNumOfHotels(), hotelChain.getAddress(), id);
    }

    // Delete a hotel chain by ID
    public void deleteHotelChain(Long id) {
        String sql = "DELETE FROM hotel_chain WHERE hotel_chain_ID = ?";
        jdbcTemplate.update(sql, id);
    }

    // Add a phone number to a hotel chain
    public void addPhone(Long hotelChainId, String phone) {
        String sql = "INSERT INTO hotel_chain_phone (hotel_chain_ID, phone) VALUES (?, ?)";
        jdbcTemplate.update(sql, hotelChainId, phone);
    }

    // Add an email to a hotel chain
    public void addEmail(Long hotelChainId, String email) {
        String sql = "INSERT INTO hotel_chain_email (hotel_chain_ID, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, hotelChainId, email);
    }
    // Get all phone numbers for a hotel chain
    public List<String> getPhonesByChainId(Long hotelChainId) {
        String sql = "SELECT phone FROM hotel_chain_phone WHERE hotel_chain_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{hotelChainId}, String.class);
    }

    // Get all emails for a hotel chain
    public List<String> getEmailsByChainId(Long hotelChainId) {
        String sql = "SELECT email FROM hotel_chain_email WHERE hotel_chain_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{hotelChainId}, String.class);
    }

}
