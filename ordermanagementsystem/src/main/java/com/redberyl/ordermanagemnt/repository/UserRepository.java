package com.redberyl.ordermanagemnt.repository;

import com.redberyl.ordermanagemnt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by email and password
    Optional<User> findByEmailAndPassword(String email, String password);

    // Find a user by email 
    Optional<User> findByEmail(String email);

    // Find a user by username 
    
    Optional<User> findByUsername(String username);
    
    // @Query("SELECT u FROM User u WHERE u.username LIKE 's%'")
    // List<User> findUsersByNameStartingWith();
    
    
}
