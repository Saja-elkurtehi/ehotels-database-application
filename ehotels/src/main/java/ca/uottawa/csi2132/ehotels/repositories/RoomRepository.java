package ca.uottawa.csi2132.ehotels.repositories;

import ca.uottawa.csi2132.ehotels.entities.Room;
import ca.uottawa.csi2132.ehotels.entities.RoomAmenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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
     // Available rooms query: Returns rooms that are not booked or rented in the given date range,
    // and that have a capacity greater than or equal to the specified minCapacity.
    public List<Room> getAvailableRoomsBetweenDates(Date startDate, Date endDate, int minCapacity) {
        String sql = """
            SELECT r.* FROM room r
            WHERE r.capacity >= ?
              AND r.room_ID NOT IN (
                  SELECT b.room_ID
                  FROM booking b
                  WHERE b.check_in_date < CAST(? AS DATE)
                    AND b.check_out_date > CAST(? AS DATE)
                    AND b.status = 'Reserved'
              )
              AND r.room_ID NOT IN (
                  SELECT rt.room_ID
                  FROM renting rt
                  WHERE rt.check_in_date < CAST(? AS DATE)
                    AND rt.check_out_date > CAST(? AS DATE)
              )
        """;
    
        return jdbcTemplate.query(sql,
                new Object[]{minCapacity, endDate, startDate, endDate, startDate},
                (rs, rowNum) -> new Room(
                    rs.getLong("room_ID"),
                    rs.getLong("hotel_ID"),
                    rs.getLong("price"),
                    rs.getBoolean("extension"),
                    rs.getShort("capacity"),
                    rs.getString("view_type"),
                    rs.getString("any_problems")
                )
        );
    }
    public List<Room> getAvailableRoomsBetweenDatesAndChain(Date startDate, Date endDate, int minCapacity, Long hotelChainId) {
        String sql = """
            SELECT r.* FROM room r
            JOIN hotel h ON r.hotel_ID = h.hotel_ID
            WHERE r.capacity >= ?
              AND h.hotel_chain_ID = ?
              AND r.room_ID NOT IN (
                  SELECT b.room_ID
                  FROM booking b
                  WHERE b.check_in_date < CAST(? AS DATE)
                    AND b.check_out_date > CAST(? AS DATE)
                    AND b.status = 'Reserved'
              )
              AND r.room_ID NOT IN (
                  SELECT rt.room_ID
                  FROM renting rt
                  WHERE rt.check_in_date < CAST(? AS DATE)
                    AND rt.check_out_date > CAST(? AS DATE)
              )
        """;
        
        return jdbcTemplate.query(sql,
                new Object[]{minCapacity, hotelChainId, endDate, startDate, endDate, startDate},
                (rs, rowNum) -> new Room(
                    rs.getLong("room_ID"),
                    rs.getLong("hotel_ID"),
                    rs.getLong("price"),
                    rs.getBoolean("extension"),
                    rs.getShort("capacity"),
                    rs.getString("view_type"),
                    rs.getString("any_problems")
                )
        );
    }
}
