package ca.uottawa.csi2132.ehotels.controllers;

import ca.uottawa.csi2132.ehotels.repositories.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/views")
public class ViewController {

    @Autowired
    private ViewRepository viewRepository;

    // GET /api/views/available-rooms
    @GetMapping("/available-rooms")
    public ResponseEntity<List<Map<String, Object>>> getAvailableRoomsPerArea() {
        List<Map<String, Object>> result = viewRepository.getAvailableRoomsPerArea();
        return ResponseEntity.ok(result);
    }

    // GET /api/views/room-capacity
    @GetMapping("/room-capacity")
    public ResponseEntity<List<Map<String, Object>>> getAggregatedRoomCapacity() {
        List<Map<String, Object>> result = viewRepository.getAggregatedRoomCapacity();
        return ResponseEntity.ok(result);
    }
}
