package com.safecircle.dto;

import lombok.*;
import java.math.BigDecimal;

/**
 * Community Report Data Transfer Object
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityReportDTO {
    private Integer reportId;
    private Integer userId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String riskLevel;
    private String incidentType;
    private String description;
    private Boolean isAnonymous;
    private String reportedAt;
    private Boolean verified;
    private Integer upvotes;
}
