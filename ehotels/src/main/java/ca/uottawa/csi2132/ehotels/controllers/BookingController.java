package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Booking;
import ca.uottawa.csi2132.ehotels.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    // Create a booking
    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        Long bookingId = bookingRepository.insertBooking(booking);
        return ResponseEntity.ok("Booking created with ID: " + bookingId);
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.getAllBookings();
    }

    // Update a booking
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        bookingRepository.updateBooking(id, booking);
        return ResponseEntity.ok("Booking updated");
    }

    // Delete a booking
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted");
    }
}
