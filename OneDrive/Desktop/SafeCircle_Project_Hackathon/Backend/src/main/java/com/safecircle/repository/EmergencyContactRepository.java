package com.safecircle.repository;

import com.safecircle.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * EmergencyContact Repository - Database operations for emergency contacts
 */
@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Integer> {
    
    List<EmergencyContact> findByUserIdOrderByPriorityAsc(Integer userId);
}
