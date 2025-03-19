package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Hotel;
import ca.uottawa.csi2132.ehotels.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    // 1) GET ALL
    // GET /api/hotels
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // 2) GET ONE BY ID
    // GET /api/hotels/{id}
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        return optionalHotel.orElse(null); // or throw an exception if not found
    }

    // 3) CREATE (INSERT)
    // POST /api/hotels
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        // The hotelId should be null or omitted, as the DB will assign it if using SERIAL/IDENTITY
        hotelRepository.save(hotel);
        return hotel; // returns the newly created hotel (with ID if using a DB-generated key)
    }

    // 4) UPDATE
    // PUT /api/hotels/{id}
    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel updatedHotel) {
        // Typically check if it exists
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            // set the ID from the path to ensure we update the correct record
            updatedHotel.setHotelId(id);
            hotelRepository.update(updatedHotel);
            return updatedHotel;
        }
        // If not found, you could throw a custom exception or return null/404
        return null;
    }

    // 5) DELETE
    // DELETE /api/hotels/{id}
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelRepository.deleteById(id);
    }
}
