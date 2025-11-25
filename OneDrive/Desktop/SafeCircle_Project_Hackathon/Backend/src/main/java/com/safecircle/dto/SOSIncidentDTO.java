package com.safecircle.dto;

import lombok.*;
import java.math.BigDecimal;

/**
 * SOS Incident Data Transfer Object
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SOSIncidentDTO {
    private Integer incidentId;
    private Integer userId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
    private String status;
    private String triggerTime;
    private String resolvedTime;
    private String audioRecording;
    private String notes;
}
