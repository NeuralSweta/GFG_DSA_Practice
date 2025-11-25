package com.safecircle.controller;

import com.safecircle.model.CommunityReport;
import com.safecircle.service.CommunityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Community Controller - Handle community safety reports and network features
 */
@RestController
@RequestMapping("/community")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommunityController {
    
    private final CommunityService communityService;
    
    /**
     * Create a new community safety report
     */
    @PostMapping("/report")
    public ResponseEntity<?> createReport(@RequestParam(required = false) Integer userId,
                                         @RequestParam BigDecimal latitude,
                                         @RequestParam BigDecimal longitude,
                                         @RequestParam String riskLevel,
                                         @RequestParam String incidentType,
                                         @RequestParam String description,
                                         @RequestParam(defaultValue = "false") Boolean isAnonymous) {
        try {
            CommunityReport.RiskLevel level = CommunityReport.RiskLevel.valueOf(riskLevel.toUpperCase());
            CommunityReport report = communityService.createReport(userId, latitude, longitude, 
                                                                   level, incidentType, description, isAnonymous);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating report: " + e.getMessage());
        }
    }
    
    /**
     * Get reports by risk level
     */
    @GetMapping("/reports/risk/{riskLevel}")
    public ResponseEntity<?> getByRiskLevel(@PathVariable String riskLevel) {
        try {
            CommunityReport.RiskLevel level = CommunityReport.RiskLevel.valueOf(riskLevel.toUpperCase());
            List<CommunityReport> reports = communityService.getReportsByRiskLevel(level);
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid risk level");
        }
    }
    
    /**
     * Get verified community reports
     */
    @GetMapping("/reports/verified")
    public ResponseEntity<?> getVerifiedReports() {
        List<CommunityReport> reports = communityService.getVerifiedReports();
        return ResponseEntity.ok(reports);
    }
    
    /**
     * Get nearby reports
     */
    @GetMapping("/reports/nearby")
    public ResponseEntity<?> getNearbyReports(@RequestParam BigDecimal latitude,
                                             @RequestParam BigDecimal longitude,
                                             @RequestParam(defaultValue = "5") double radiusKm) {
        List<CommunityReport> reports = communityService.getNearbyReports(latitude, longitude, radiusKm);
        return ResponseEntity.ok(reports);
    }
    
    /**
     * Upvote a report
     */
    @PostMapping("/reports/{reportId}/upvote")
    public ResponseEntity<?> upvoteReport(@PathVariable Integer reportId) {
        CommunityReport report = communityService.upvoteReport(reportId);
        if (report != null) {
            return ResponseEntity.ok(report);
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * Verify a report (admin only)
     */
    @PostMapping("/reports/{reportId}/verify")
    public ResponseEntity<?> verifyReport(@PathVariable Integer reportId) {
        CommunityReport report = communityService.verifyReport(reportId);
        if (report != null) {
            return ResponseEntity.ok(report);
        }
        return ResponseEntity.notFound().build();
    }
}
