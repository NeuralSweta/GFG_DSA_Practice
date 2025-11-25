package com.safecircle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SafeCircle Application Entry Point
 * Women Safety and Tech - Intelligent SOS System with AI-powered Risk Detection
 * 
 * @author Sweta Jha
 * @version 1.0.0
 */
@SpringBootApplication
public class SafeCircleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafeCircleApplication.class, args);
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   SafeCircle - Women Safety & Tech App    ║");
        System.out.println("║   IEEE Hackathon Project - 2025           ║");
        System.out.println("║   Empowering Women Through Technology      ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
