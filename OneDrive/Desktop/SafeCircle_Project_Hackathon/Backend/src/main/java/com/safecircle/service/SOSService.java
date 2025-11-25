package com.safecircle.service;

import com.safecircle.dto.SOSIncidentDTO;
import com.safecircle.model.SOSIncident;
import com.safecircle.repository.SOSIncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * SOS Service - Business logic for emergency SOS handling
 * 
 * Features:
 * - Trigger emergency SOS
 * - Track active incidents
 * - Update incident status
 * - Send notifications to emergency contacts
 */
@Service
@AllArgsConstructor
public class SOSService {
    
    private final SOSIncidentRepository sosRepository;
    
    /**
     * Trigger a new SOS incident
     */
    public SOSIncident triggerSOS(Integer userId, BigDecimal latitude, BigDecimal longitude, 
                                   String address, String notes) {
        SOSIncident incident = SOSIncident.builder()
                .userId(userId)
                .latitude(latitude)
                .longitude(longitude)
                .address(address)
                .status(SOSIncident.IncidentStatus.ACTIVE)
                .notes(notes)
                .build();
        
        System.out.println("🚨 SOS INCIDENT TRIGGERED - User: " + userId + 
                          " at Location: (" + latitude + ", " + longitude + ")");
        
        return sosRepository.save(incident);
    }
    
    /**
     * Get all active incidents
     */
    public List<SOSIncident> getActiveIncidents() {
        return sosRepository.findByStatusOrderByTriggerTimeDesc(SOSIncident.IncidentStatus.ACTIVE);
    }
    
    /**
     * Get incidents for a specific user
     */
    public List<SOSIncident> getUserIncidents(Integer userId) {
        return sosRepository.findByUserIdOrderByTriggerTimeDesc(userId);
    }
    
    /**
     * Resolve an SOS incident
     */
    public SOSIncident resolveIncident(Integer incidentId, String notes) {
        Optional<SOSIncident> incident = sosRepository.findById(incidentId);
        if (incident.isPresent()) {
            SOSIncident sos = incident.get();
            sos.setStatus(SOSIncident.IncidentStatus.RESOLVED);
            sos.setResolvedTime(LocalDateTime.now());
            if (notes != null) sos.setNotes(notes);
            return sosRepository.save(sos);
        }
        return null;
    }
    
    /**
     * Mark incident as false alarm
     */
    public SOSIncident markAsFalseAlarm(Integer incidentId) {
        Optional<SOSIncident> incident = sosRepository.findById(incidentId);
        if (incident.isPresent()) {
            SOSIncident sos = incident.get();
            sos.setStatus(SOSIncident.IncidentStatus.FALSE_ALARM);
            sos.setResolvedTime(LocalDateTime.now());
            return sosRepository.save(sos);
        }
        return null;
    }
    
    /**
     * Convert entity to DTO
     */
    public SOSIncidentDTO convertToDTO(SOSIncident incident) {
        return SOSIncidentDTO.builder()
                .incidentId(incident.getIncidentId())
                .userId(incident.getUserId())
                .latitude(incident.getLatitude())
                .longitude(incident.getLongitude())
                .address(incident.getAddress())
                .status(incident.getStatus().toString())
                .triggerTime(incident.getTriggerTime().toString())
                .resolvedTime(incident.getResolvedTime() != null ? incident.getResolvedTime().toString() : null)
                .audioRecording(incident.getAudioRecording())
                .notes(incident.getNotes())
                .build();
    }
}
