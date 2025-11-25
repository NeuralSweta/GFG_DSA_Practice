package com.safecircle.repository;

import com.safecircle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * User Repository - Database operations for User entity
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByPhone(String phone);
    
    Optional<User> findByEmailOrPhone(String email, String phone);
}
