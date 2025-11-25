package com.safecircle.dto;

import lombok.*;

/**
 * User Data Transfer Object
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer userId;
    private String name;
    private String email;
    private String phone;
    private String profileImage;
    private Boolean isActive;
    private String createdAt;
    private String lastLogin;
}
