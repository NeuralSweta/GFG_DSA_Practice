package com.safecircle.controller;

import com.safecircle.model.SafeZone;
import com.safecircle.repository.SafeZoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Safe Zone Controller - Safe location management
 */
@RestController
@RequestMapping("/zones")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class SafeZoneController {
    
    private final SafeZoneRepository safeZoneRepository;
    
    /**
     * Get all safe zones
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllSafeZones() {
        List<SafeZone> zones = safeZoneRepository.findAll();
        return ResponseEntity.ok(zones);
    }
    
    /**
     * Get safe zones by type
     */
    @GetMapping("/type/{type}")
    public ResponseEntity<?> getZonesByType(@PathVariable String type) {
        try {
            SafeZone.ZoneType zoneType = SafeZone.ZoneType.valueOf(type.toUpperCase());
            List<SafeZone> zones = safeZoneRepository.findByZoneType(zoneType);
            return ResponseEntity.ok(zones);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid zone type");
        }
    }
    
    /**
     * Get nearby safe zones
     */
    @GetMapping("/nearby")
    public ResponseEntity<?> getNearbyZones(@RequestParam BigDecimal latitude,
                                           @RequestParam BigDecimal longitude,
                                           @RequestParam(defaultValue = "5") double radiusKm) {
        List<SafeZone> zones = safeZoneRepository.findNearby(latitude, longitude, radiusKm);
        return ResponseEntity.ok(zones);
    }
    
    /**
     * Add new safe zone
     */
    @PostMapping("/add")
    public ResponseEntity<?> addSafeZone(@RequestParam String zoneName,
                                        @RequestParam BigDecimal latitude,
                                        @RequestParam BigDecimal longitude,
                                        @RequestParam String zoneType) {
        try {
            SafeZone zone = SafeZone.builder()
                    .zoneName(zoneName)
                    .latitude(latitude)
                    .longitude(longitude)
                    .zoneType(SafeZone.ZoneType.valueOf(zoneType.toUpperCase()))
                    .safetyScore(BigDecimal.valueOf(5.0))
                    .build();
            
            SafeZone saved = safeZoneRepository.save(zone);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding safe zone: " + e.getMessage());
        }
    }
}
