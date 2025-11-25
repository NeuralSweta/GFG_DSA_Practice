package com.safecircle.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * SOSIncident Entity - Tracks SOS emergency calls
 */
@Entity
@Table(name = "sos_incidents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SOSIncident {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_id")
    private Integer incidentId;
    
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @Column(nullable = false, precision = 10, scale = 8)
    private BigDecimal latitude;
    
    @Column(nullable = false, precision = 11, scale = 8)
    private BigDecimal longitude;
    
    @Column(length = 255)
    private String address;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('active', 'resolved', 'false_alarm') DEFAULT 'active'")
    private IncidentStatus status;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime triggerTime;
    
    @Column
    private LocalDateTime resolvedTime;
    
    @Column(length = 255)
    private String audioRecording;
    
    @Column(columnDefinition = "TEXT")
    private String notes;
    
    @PrePersist
    protected void onCreate() {
        triggerTime = LocalDateTime.now();
        status = IncidentStatus.ACTIVE;
    }
    
    public enum IncidentStatus {
        ACTIVE, RESOLVED, FALSE_ALARM
    }
}
