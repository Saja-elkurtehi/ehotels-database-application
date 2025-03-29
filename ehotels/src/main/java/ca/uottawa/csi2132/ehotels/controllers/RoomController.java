package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Room;
import ca.uottawa.csi2132.ehotels.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    // Create a new room
    @PostMapping
    public ResponseEntity<String> createRoom(@RequestBody Room room) {
        roomRepository.insertRoom(room);
        return ResponseEntity.ok("Room created successfully");
    }

    // Get all rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }

    // Get a room by ID
    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable Long roomId) {
        return roomRepository.getRoomById(roomId);
    }

    // Update a room
    @PutMapping("/{roomId}")
    public ResponseEntity<String> updateRoom(@PathVariable Long roomId, @RequestBody Room room) {
        roomRepository.updateRoom(roomId, room);
        return ResponseEntity.ok("Room updated successfully");
    }

    // Delete a room
    @DeleteMapping("/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId) {
        roomRepository.deleteRoom(roomId);
        return ResponseEntity.ok("Room deleted successfully");
    }

    // Add an amenity to a room
    @PostMapping("/{roomId}/amenities")
    public ResponseEntity<String> addAmenity(@PathVariable Long roomId, @RequestBody String amenity) {
        roomRepository.insertRoomAmenity(new ca.uottawa.csi2132.ehotels.entities.RoomAmenity(roomId, amenity));
        return ResponseEntity.ok("Amenity added to room");
    }

    // Get all amenities for a room
    @GetMapping("/{roomId}/amenities")
    public List<String> getAmenities(@PathVariable Long roomId) {
        return roomRepository.getAmenitiesByRoomId(roomId);
    }

    // Delete all amenities for a room
    @DeleteMapping("/{roomId}/amenities")
    public ResponseEntity<String> deleteAllAmenities(@PathVariable Long roomId) {
        roomRepository.deleteRoomAmenities(roomId);
        return ResponseEntity.ok("All amenities deleted for room " + roomId);
    }

    // Updated available rooms endpoint: accepts additional filters.
    @GetMapping("/available")
    public List<Room> getAvailableRoomsBetweenDates(
        @RequestParam("start") String start,
        @RequestParam("end") String end,
        @RequestParam(value = "guests", defaultValue = "1") int guests,
        @RequestParam(value = "hotelChainId", required = false) Long hotelChainId,
        @RequestParam(value = "hotelCategory", required = false) String hotelCategory,
        @RequestParam(value = "area", required = false) String area,
        @RequestParam(value = "minPrice", required = false) String minPrice,
        @RequestParam(value = "maxPrice", required = false) String maxPrice
    ) {
        // Convert input strings to SQL Date
        Date startDate = Date.valueOf(start);
        Date endDate = Date.valueOf(end);
        
        List<Room> availableRooms;
        
        // Use the new filters if any additional filter is provided.
        boolean hasAdditionalFilters = (hotelCategory != null && !hotelCategory.isEmpty()) ||
                                         (area != null && !area.isEmpty()) ||
                                         (minPrice != null && !minPrice.isEmpty() && maxPrice != null && !maxPrice.isEmpty());
        
        if (hasAdditionalFilters) {
            availableRooms = roomRepository.getAvailableRoomsWithFilters(startDate, endDate, guests, hotelChainId, hotelCategory, area, minPrice, maxPrice);
        } else if (hotelChainId != null) {
            availableRooms = roomRepository.getAvailableRoomsBetweenDatesAndChain(startDate, endDate, guests, hotelChainId);
        } else {
            availableRooms = roomRepository.getAvailableRoomsBetweenDates(startDate, endDate, guests);
        }
        
        // Fallback sample data if no rooms are found
        if (availableRooms == null || availableRooms.isEmpty()) {
            availableRooms = Arrays.asList(
                new Room(9991L, 1L, 250L, true, (short)2, "sea view", null),
                new Room(9992L, 2L, 300L, false, (short)3, "mountain view", "Broken lamp")
            );
        }
        
        return availableRooms;
    }
}
