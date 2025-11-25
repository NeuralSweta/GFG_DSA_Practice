package com.safecircle.exception;

/**
 * Global exception handler for SafeCircle application
 */
public class SafeCircleException extends RuntimeException {
    
    public SafeCircleException(String message) {
        super(message);
    }
    
    public SafeCircleException(String message, Throwable cause) {
        super(message, cause);
    }
}
