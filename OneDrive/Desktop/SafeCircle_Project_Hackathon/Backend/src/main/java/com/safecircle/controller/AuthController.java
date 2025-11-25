package com.safecircle.controller;

import com.safecircle.dto.AuthRequest;
import com.safecircle.dto.AuthResponse;
import com.safecircle.model.User;
import com.safecircle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Authentication Controller - Handle user authentication and registration
 */
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    
    private final UserService userService;
    
    /**
     * User login endpoint
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        var user = userService.findByEmail(request.getEmail());
        
        if (user.isPresent() && userService.verifyPassword(request.getPassword(), user.get().getPasswordHash())) {
            return ResponseEntity.ok(AuthResponse.builder()
                    .token("jwt_token_here")
                    .type("Bearer")
                    .user(userService.convertToDTO(user.get()))
                    .message("Login successful")
                    .build());
        }
        
        return ResponseEntity.badRequest().body(
                AuthResponse.builder()
                    .message("Invalid email or password")
                    .build()
        );
    }
    
    /**
     * User registration endpoint
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request,
                                     @RequestParam String name,
                                     @RequestParam String phone) {
        try {
            User newUser = userService.registerUser(name, request.getEmail(), phone, request.getPassword());
            return ResponseEntity.ok(AuthResponse.builder()
                    .token("jwt_token_here")
                    .type("Bearer")
                    .user(userService.convertToDTO(newUser))
                    .message("Registration successful")
                    .build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    AuthResponse.builder()
                        .message("Registration failed: " + e.getMessage())
                        .build()
            );
        }
    }
}
