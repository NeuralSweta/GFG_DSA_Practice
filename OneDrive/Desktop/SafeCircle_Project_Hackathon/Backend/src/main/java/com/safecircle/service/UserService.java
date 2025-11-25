package com.safecircle.service;

import com.safecircle.dto.UserDTO;
import com.safecircle.model.User;
import com.safecircle.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * User Service - Business logic for user management
 */
@Service
@AllArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    
    /**
     * Register a new user
     */
    public User registerUser(String name, String email, String phone, String password) {
        User user = User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .passwordHash(passwordEncoder.encode(password))
                .isActive(true)
                .build();
        return userRepository.save(user);
    }
    
    /**
     * Find user by email
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    /**
     * Find user by phone
     */
    public Optional<User> findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }
    
    /**
     * Verify user password
     */
    public boolean verifyPassword(String password, String hash) {
        return passwordEncoder.matches(password, hash);
    }
    
    /**
     * Update user profile
     */
    public User updateUser(Integer userId, String name, String profileImage) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            if (name != null) user.setName(name);
            if (profileImage != null) user.setProfileImage(profileImage);
            return userRepository.save(user);
        }
        return null;
    }
    
    /**
     * Convert User entity to DTO
     */
    public UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .profileImage(user.getProfileImage())
                .isActive(user.getIsActive())
                .createdAt(user.getCreatedAt().toString())
                .lastLogin(user.getLastLogin() != null ? user.getLastLogin().toString() : null)
                .build();
    }
}
