package com.safecircle.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * EmergencyContact Entity - User's emergency contacts for SOS
 */
@Entity
@Table(name = "emergency_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyContact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer contactId;
    
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @Column(nullable = false, length = 100)
    private String contactName;
    
    @Column(nullable = false, length = 15)
    private String contactPhone;
    
    @Column(length = 50)
    private String relationship;
    
    @Column(nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer priority;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (priority == null) {
            priority = 1;
        }
    }
}
