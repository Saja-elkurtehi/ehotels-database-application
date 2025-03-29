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

    // Create a booking. The booking data comes in the request body,
    // and the customerId and roomId are provided as query parameters.
    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Booking booking,
                                                  @RequestParam Long customerId,
                                                  @RequestParam Long roomId) {
        // Set customer and room IDs from query parameters into the booking object
        booking.setCustomerId(customerId);
        booking.setRoomId(roomId);
        // Insert the booking record and retrieve its generated ID
        Long bookingId = bookingRepository.insertBooking(booking);
        // Optionally, insert a linking record into the books table
        bookingRepository.linkBooking(bookingId, customerId, roomId);
        return ResponseEntity.ok("Booking created and linked with ID: " + bookingId);
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
