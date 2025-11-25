package com.safecircle.dto;

import lombok.*;

/**
 * Authentication Response DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private String type;
    private UserDTO user;
    private String message;
}
