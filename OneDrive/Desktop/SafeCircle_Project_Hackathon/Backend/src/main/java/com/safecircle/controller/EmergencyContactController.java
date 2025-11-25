package com.safecircle.controller;

import com.safecircle.model.EmergencyContact;
import com.safecircle.repository.EmergencyContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Emergency Contact Controller - Manage emergency contacts
 */
@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmergencyContactController {
    
    private final EmergencyContactRepository contactRepository;
    
    /**
     * Add emergency contact
     */
    @PostMapping("/add")
    public ResponseEntity<?> addContact(@RequestParam Integer userId,
                                       @RequestParam String contactName,
                                       @RequestParam String contactPhone,
                                       @RequestParam(required = false) String relationship,
                                       @RequestParam(defaultValue = "1") Integer priority) {
        try {
            EmergencyContact contact = EmergencyContact.builder()
                    .userId(userId)
                    .contactName(contactName)
                    .contactPhone(contactPhone)
                    .relationship(relationship)
                    .priority(priority)
                    .build();
            
            EmergencyContact saved = contactRepository.save(contact);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding contact: " + e.getMessage());
        }
    }
    
    /**
     * Get user's emergency contacts
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserContacts(@PathVariable Integer userId) {
        List<EmergencyContact> contacts = contactRepository.findByUserIdOrderByPriorityAsc(userId);
        return ResponseEntity.ok(contacts);
    }
    
    /**
     * Delete emergency contact
     */
    @DeleteMapping("/{contactId}")
    public ResponseEntity<?> deleteContact(@PathVariable Integer contactId) {
        try {
            contactRepository.deleteById(contactId);
            return ResponseEntity.ok("Contact deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting contact");
        }
    }
}
