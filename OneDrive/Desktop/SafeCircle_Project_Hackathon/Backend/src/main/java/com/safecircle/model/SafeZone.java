package com.safecircle.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * SafeZone Entity - Safe locations marked by authorities or community
 */
@Entity
@Table(name = "safe_zones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SafeZone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id")
    private Integer zoneId;
    
    @Column(nullable = false, length = 100)
    private String zoneName;
    
    @Column(nullable = false, precision = 10, scale = 8)
    private BigDecimal latitude;
    
    @Column(nullable = false, precision = 11, scale = 8)
    private BigDecimal longitude;
    
    @Column(nullable = false)
    private Integer radius; // in meters
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ZoneType zoneType;
    
    @Column(precision = 3, scale = 2, columnDefinition = "DECIMAL(3,2) DEFAULT 5.0")
    private BigDecimal safetyScore;
    
    @Column(name = "verified_by")
    private Integer verifiedBy;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (safetyScore == null) {
            safetyScore = BigDecimal.valueOf(5.0);
        }
    }
    
    public enum ZoneType {
        POLICE_STATION, HOSPITAL, VERIFIED_SAFE, COMMUNITY_MARKED
    }
}
