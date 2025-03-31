package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Booking;
import ca.uottawa.csi2132.ehotels.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;  // For @Transactional
import org.springframework.http.HttpStatus;                     // For HttpStatus
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // Create a booking. The booking data comes in the request body,
    // and the customerId and roomId are provided as query parameters.
    @PostMapping
    @Transactional
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Long bookingId = bookingRepository.insertBooking(booking);
            bookingRepository.linkBooking(bookingId, booking.getCustomerId(), booking.getRoomId());

            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "bookingId", bookingId
            ));
        } catch (DataIntegrityViolationException e) {
            // Extract the PostgreSQL error message
            String pgError = e.getMostSpecificCause().getMessage();

            // Create user-friendly response
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "error", "booking_conflict",
                    "message", "The room is not available for your selected dates",
                    "details", pgError,  // Original error for debugging
                    "roomId", booking.getRoomId(),
                    "suggestion", "Please try different dates or another room"
            ));
        }
    }
   // Create a booking with customer and room details via query parameters
    @PostMapping("/with-params")
    public ResponseEntity<String> create2Booking(@RequestBody Booking booking,
                                                @RequestParam Long customerId,
                                                @RequestParam Long roomId) {
        booking.setCustomerId(customerId);
        booking.setRoomId(roomId);
        Long bookingId = bookingRepository.insertBooking(booking);
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
