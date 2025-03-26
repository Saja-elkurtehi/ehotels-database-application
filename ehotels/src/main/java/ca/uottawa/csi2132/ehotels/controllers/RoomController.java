package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Room;
import ca.uottawa.csi2132.ehotels.entities.RoomAmenity;
import ca.uottawa.csi2132.ehotels.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        roomRepository.insertRoomAmenity(new RoomAmenity(roomId, amenity));
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
}
