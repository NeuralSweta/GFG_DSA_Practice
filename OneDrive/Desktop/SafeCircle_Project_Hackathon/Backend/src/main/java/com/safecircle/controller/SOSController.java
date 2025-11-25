package com.safecircle.controller;

import com.safecircle.dto.SOSIncidentDTO;
import com.safecircle.model.SOSIncident;
import com.safecircle.service.SOSService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SOS Controller - Handle emergency SOS requests
 * 
 * Endpoints for triggering SOS, tracking incidents, and resolving emergencies
 */
@RestController
@RequestMapping("/sos")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class SOSController {
    
    private final SOSService sosService;
    
    /**
     * Trigger a new SOS emergency
     */
    @PostMapping("/trigger")
    public ResponseEntity<?> triggerSOS(@RequestParam Integer userId,
                                       @RequestParam BigDecimal latitude,
                                       @RequestParam BigDecimal longitude,
                                       @RequestParam(required = false) String address,
                                       @RequestParam(required = false) String notes) {
        try {
            SOSIncident incident = sosService.triggerSOS(userId, latitude, longitude, address, notes);
            return ResponseEntity.ok(ResponseEntity.ok()
                    .body("SOS Triggered Successfully! Incident ID: " + incident.getIncidentId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error triggering SOS: " + e.getMessage());
        }
    }
    
    /**
     * Get all active incidents
     */
    @GetMapping("/active")
    public ResponseEntity<?> getActiveIncidents() {
        List<SOSIncident> incidents = sosService.getActiveIncidents();
        List<SOSIncidentDTO> dtos = incidents.stream()
                .map(sosService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    
    /**
     * Get incidents for a specific user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserIncidents(@PathVariable Integer userId) {
        List<SOSIncident> incidents = sosService.getUserIncidents(userId);
        List<SOSIncidentDTO> dtos = incidents.stream()
                .map(sosService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    
    /**
     * Resolve an SOS incident
     */
    @PostMapping("/resolve/{incidentId}")
    public ResponseEntity<?> resolveIncident(@PathVariable Integer incidentId,
                                           @RequestParam(required = false) String notes) {
        SOSIncident resolved = sosService.resolveIncident(incidentId, notes);
        if (resolved != null) {
            return ResponseEntity.ok(sosService.convertToDTO(resolved));
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * Mark incident as false alarm
     */
    @PostMapping("/false-alarm/{incidentId}")
    public ResponseEntity<?> falseAlarm(@PathVariable Integer incidentId) {
        SOSIncident incident = sosService.markAsFalseAlarm(incidentId);
        if (incident != null) {
            return ResponseEntity.ok(sosService.convertToDTO(incident));
        }
        return ResponseEntity.notFound().build();
    }
}
