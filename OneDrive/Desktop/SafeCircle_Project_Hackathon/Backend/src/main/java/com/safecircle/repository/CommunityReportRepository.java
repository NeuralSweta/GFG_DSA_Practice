package com.safecircle.repository;

import com.safecircle.model.CommunityReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

/**
 * CommunityReport Repository - Database operations for community reports
 */
@Repository
public interface CommunityReportRepository extends JpaRepository<CommunityReport, Integer> {
    
    List<CommunityReport> findByRiskLevel(CommunityReport.RiskLevel riskLevel);
    
    List<CommunityReport> findByVerifiedTrueOrderByUpvotesDesc();
    
    @Query("SELECT cr FROM CommunityReport cr WHERE " +
           "SQRT(POW(69.1 * (cr.latitude - ?1), 2) + " +
           "POW(69.1 * (?2 - cr.longitude) * COS(cr.latitude / 57.3), 2)) < ?3")
    List<CommunityReport> findNearby(BigDecimal latitude, BigDecimal longitude, double radiusKm);
}
