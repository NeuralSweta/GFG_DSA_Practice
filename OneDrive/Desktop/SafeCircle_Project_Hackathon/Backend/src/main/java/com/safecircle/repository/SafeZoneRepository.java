package com.safecircle.repository;

import com.safecircle.model.SafeZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

/**
 * SafeZone Repository - Database operations for safe zones
 */
@Repository
public interface SafeZoneRepository extends JpaRepository<SafeZone, Integer> {
    
    List<SafeZone> findByZoneType(SafeZone.ZoneType zoneType);
    
    @Query("SELECT sz FROM SafeZone sz WHERE " +
           "SQRT(POW(69.1 * (sz.latitude - ?1), 2) + " +
           "POW(69.1 * (?2 - sz.longitude) * COS(sz.latitude / 57.3), 2)) < ?3")
    List<SafeZone> findNearby(BigDecimal latitude, BigDecimal longitude, double radiusKm);
}
