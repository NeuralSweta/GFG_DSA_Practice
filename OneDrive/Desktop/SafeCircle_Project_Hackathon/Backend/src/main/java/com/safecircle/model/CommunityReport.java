package com.safecircle.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * CommunityReport Entity - Tracks community safety reports and risk zones
 */
@Entity
@Table(name = "community_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityReport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer reportId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(nullable = false, precision = 10, scale = 8)
    private BigDecimal latitude;
    
    @Column(nullable = false, precision = 11, scale = 8)
    private BigDecimal longitude;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('low', 'medium', 'high', 'critical') NOT NULL")
    private RiskLevel riskLevel;
    
    @Column(length = 50)
    private String incidentType;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isAnonymous;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime reportedAt;
    
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean verified;
    
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer upvotes;
    
    @PrePersist
    protected void onCreate() {
        reportedAt = LocalDateTime.now();
        verified = false;
        upvotes = 0;
    }
    
    public enum RiskLevel {
        LOW, MEDIUM, HIGH, CRITICAL
    }
}
