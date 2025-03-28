package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.entities.Renting;
import ca.uottawa.csi2132.ehotels.repositories.RentingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentings")
public class RentingController {

    @Autowired
    private RentingRepository rentingRepository;

    // Create a new renting
    @PostMapping
    public ResponseEntity<String> createRenting(@RequestBody Renting renting) {
        rentingRepository.insertRenting(renting);
        return ResponseEntity.ok("Renting created");
    }

    // Get all rentings
    @GetMapping
    public List<Renting> getAllRentings() {
        return rentingRepository.getAllRentings();
    }

    // Get renting by ID
    @GetMapping("/{id}")
    public ResponseEntity<Renting> getRentingById(@PathVariable Long id) {
        Renting renting = rentingRepository.getRentingById(id);
        return ResponseEntity.ok(renting);
    }

    // Update a renting
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRenting(@PathVariable Long id, @RequestBody Renting renting) {
        rentingRepository.updateRenting(id, renting);
        return ResponseEntity.ok("Renting updated");
    }

    // Delete a renting
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRenting(@PathVariable Long id) {
        rentingRepository.deleteRenting(id);
        return ResponseEntity.ok("Renting deleted");
    }
}
