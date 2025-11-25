package com.safecircle.repository;

import com.safecircle.model.SOSIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

/**
 * SOSIncident Repository - Database operations for SOS incidents
 */
@Repository
public interface SOSIncidentRepository extends JpaRepository<SOSIncident, Integer> {
    
    List<SOSIncident> findByUserIdOrderByTriggerTimeDesc(Integer userId);
    
    List<SOSIncident> findByStatusOrderByTriggerTimeDesc(SOSIncident.IncidentStatus status);
    
    List<SOSIncident> findByTriggerTimeBetween(LocalDateTime start, LocalDateTime end);
}
