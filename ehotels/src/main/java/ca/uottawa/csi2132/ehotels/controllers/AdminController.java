package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.*;
import ca.uottawa.csi2132.ehotels.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired private HotelChainRepository hotelChainRepo;
    @Autowired private HotelRepository hotelRepo;
    @Autowired private RoomRepository roomRepo;

    // ---------------- HOTEL CHAIN ----------------

    @PostMapping("/hotel-chains")
    public ResponseEntity<String> createHotelChain(@RequestBody HotelChain hotelChain) {
        hotelChainRepo.insertHotelChain(hotelChain);
        return ResponseEntity.ok("Hotel chain created");
    }

    @GetMapping("/hotel-chains")
    public List<HotelChain> getAllHotelChains() {
        return hotelChainRepo.getAllHotelChains();
    }

    @PutMapping("/hotel-chains/{id}")
    public ResponseEntity<String> updateHotelChain(@PathVariable Long id, @RequestBody HotelChain hotelChain) {
        hotelChainRepo.updateHotelChain(id, hotelChain);
        return ResponseEntity.ok("Hotel chain updated");
    }

    @DeleteMapping("/hotel-chains/{id}")
    public ResponseEntity<String> deleteHotelChain(@PathVariable Long id) {
        hotelChainRepo.deleteHotelChain(id);
        return ResponseEntity.ok("Hotel chain deleted");
    }

    @PostMapping("/hotel-chains/{id}/phone")
    public ResponseEntity<String> addChainPhone(@PathVariable Long id, @RequestBody String phone) {
        hotelChainRepo.addPhone(id, phone);
        return ResponseEntity.ok("Phone added to hotel chain");
    }

    @PostMapping("/hotel-chains/{id}/email")
    public ResponseEntity<String> addChainEmail(@PathVariable Long id, @RequestBody String email) {
        hotelChainRepo.addEmail(id, email);
        return ResponseEntity.ok("Email added to hotel chain");
    }

    // ---------------- HOTEL ----------------

    @PostMapping("/hotels")
    public ResponseEntity<String> createHotel(@RequestBody Hotel hotel) {
        hotelRepo.insertHotel(hotel);
        return ResponseEntity.ok("Hotel created");
    }

    @PostMapping("/hotels/{id}/phone")
    public ResponseEntity<String> addHotelPhone(@PathVariable Long id, @RequestBody String phone) {
        hotelRepo.addPhone(id, phone);
        return ResponseEntity.ok("Phone added to hotel");
    }

    @PostMapping("/hotels/{id}/email")
    public ResponseEntity<String> addHotelEmail(@PathVariable Long id, @RequestBody String email) {
        hotelRepo.addEmail(id, email);
        return ResponseEntity.ok("Email added to hotel");
    }

    // ---------------- ROOM ----------------

    @PostMapping("/rooms")
    public ResponseEntity<String> createRoom(@RequestBody Room room) {
        roomRepo.insertRoom(room);
        return ResponseEntity.ok("Room created");
    }

    @PostMapping("/rooms/{roomId}/amenity")
    public ResponseEntity<String> addAmenity(@PathVariable Long roomId, @RequestBody String amenity) {
        roomRepo.insertRoomAmenity(new RoomAmenity(roomId, amenity));
        return ResponseEntity.ok("Amenity added to room");
    }

    @DeleteMapping("/rooms/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId) {
        roomRepo.deleteRoom(roomId);
        return ResponseEntity.ok("Room deleted");
    }
}
