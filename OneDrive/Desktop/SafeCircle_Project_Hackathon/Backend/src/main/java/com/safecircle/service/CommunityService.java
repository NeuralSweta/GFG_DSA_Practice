package com.safecircle.service;

import com.safecircle.model.CommunityReport;
import com.safecircle.repository.CommunityReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Community Service - Business logic for community safety network
 * 
 * Features:
 * - Report safety concerns
 * - Mark risk zones
 * - Community verification
 * - Anonymous reporting
 */
@Service
@AllArgsConstructor
public class CommunityService {
    
    private final CommunityReportRepository reportRepository;
    
    /**
     * Create a community report
     */
    public CommunityReport createReport(Integer userId, BigDecimal latitude, BigDecimal longitude,
                                       CommunityReport.RiskLevel riskLevel, String incidentType,
                                       String description, Boolean isAnonymous) {
        CommunityReport report = CommunityReport.builder()
                .userId(isAnonymous ? null : userId)
                .latitude(latitude)
                .longitude(longitude)
                .riskLevel(riskLevel)
                .incidentType(incidentType)
                .description(description)
                .isAnonymous(isAnonymous)
                .verified(false)
                .build();
        
        System.out.println("📍 Community Report - Risk Level: " + riskLevel + 
                          " at Location: (" + latitude + ", " + longitude + ")");
        
        return reportRepository.save(report);
    }
    
    /**
     * Get reports by risk level
     */
    public List<CommunityReport> getReportsByRiskLevel(CommunityReport.RiskLevel riskLevel) {
        return reportRepository.findByRiskLevel(riskLevel);
    }
    
    /**
     * Get verified reports sorted by upvotes
     */
    public List<CommunityReport> getVerifiedReports() {
        return reportRepository.findByVerifiedTrueOrderByUpvotesDesc();
    }
    
    /**
     * Find nearby reports
     */
    public List<CommunityReport> getNearbyReports(BigDecimal latitude, BigDecimal longitude, double radiusKm) {
        return reportRepository.findNearby(latitude, longitude, radiusKm);
    }
    
    /**
     * Upvote a report
     */
    public CommunityReport upvoteReport(Integer reportId) {
        Optional<CommunityReport> report = reportRepository.findById(reportId);
        if (report.isPresent()) {
            CommunityReport r = report.get();
            r.setUpvotes(r.getUpvotes() + 1);
            return reportRepository.save(r);
        }
        return null;
    }
    
    /**
     * Verify a report (admin action)
     */
    public CommunityReport verifyReport(Integer reportId) {
        Optional<CommunityReport> report = reportRepository.findById(reportId);
        if (report.isPresent()) {
            CommunityReport r = report.get();
            r.setVerified(true);
            return reportRepository.save(r);
        }
        return null;
    }
}
