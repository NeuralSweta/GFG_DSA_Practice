package com.safecircle.dto;

import lombok.*;

/**
 * Authentication Request DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequest {
    private String email;
    private String password;
}
