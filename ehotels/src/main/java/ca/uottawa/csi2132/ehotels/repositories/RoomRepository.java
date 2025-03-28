package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Room;
import ca.uottawa.csi2132.ehotels.entities.RoomAmenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert a room
    public void insertRoom(Room room) {
        String sql = "INSERT INTO room (hotel_ID, price, extension, capacity, view_type, any_problems) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                room.getHotelId(),
                room.getPrice(),
                room.getExtension(),
                room.getCapacity(),
                room.getViewType(),
                room.getAnyProblems());
    }

    // Insert a room amenity
    public void insertRoomAmenity(RoomAmenity amenity) {
        String sql = "INSERT INTO room_amenity (room_ID, amenity) VALUES (?, ?)";
        jdbcTemplate.update(sql, amenity.getRoomId(), amenity.getAmenity());
    }

    // Get all rooms
    public List<Room> getAllRooms() {
        String sql = "SELECT * FROM room";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Room(
                rs.getLong("room_ID"),
                rs.getLong("hotel_ID"),
                rs.getLong("price"),
                rs.getBoolean("extension"),
                rs.getShort("capacity"),
                rs.getString("view_type"),
                rs.getString("any_problems")
        ));
    }

    // Get a single room by ID
    public Room getRoomById(Long roomId) {
        String sql = "SELECT * FROM room WHERE room_ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{roomId}, (rs, rowNum) -> new Room(
                rs.getLong("room_ID"),
                rs.getLong("hotel_ID"),
                rs.getLong("price"),
                rs.getBoolean("extension"),
                rs.getShort("capacity"),
                rs.getString("view_type"),
                rs.getString("any_problems")
        ));
    }

    // Get amenities for a specific room
    public List<String> getAmenitiesByRoomId(Long roomId) {
        String sql = "SELECT amenity FROM room_amenity WHERE room_ID = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{roomId}, String.class);
    }

    // Update a room's info
    public void updateRoom(Long roomId, Room room) {
        String sql = "UPDATE room SET hotel_ID = ?, price = ?, extension = ?, capacity = ?, view_type = ?, any_problems = ? " +
                     "WHERE room_ID = ?";
        jdbcTemplate.update(sql,
                room.getHotelId(),
                room.getPrice(),
                room.getExtension(),
                room.getCapacity(),
                room.getViewType(),
                room.getAnyProblems(),
                roomId);
    }

    // Delete a room
    public void deleteRoom(Long roomId) {
        String sql = "DELETE FROM room WHERE room_ID = ?";
        jdbcTemplate.update(sql, roomId);
    }

    // Delete amenities for a room
    public void deleteRoomAmenities(Long roomId) {
        String sql = "DELETE FROM room_amenity WHERE room_ID = ?";
        jdbcTemplate.update(sql, roomId);
    }
}
