package com.redberyl.ordermanagemnt.service.impl;

import com.redberyl.ordermanagemnt.exception.ResourceNotFoundException;
import com.redberyl.ordermanagemnt.model.User;
import com.redberyl.ordermanagemnt.repository.UserRepository;
import com.redberyl.ordermanagemnt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        // Save the new user to the repository
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        // Retrieve all users from the repository
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        // Retrieve user by ID, or throw exception if not found
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        // Retrieve user by email and password, or throw exception if not found
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        return user.orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        // Find the existing user by ID
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found"));

        // Update the existing user's details
        existingUser.setUsername(userDetails.getUsername());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setMobile(userDetails.getMobile());
        existingUser.setPassword(userDetails.getPassword());

        // Save and return the updated user
        return userRepository.save(existingUser);
    }

    @Override
    public boolean deleteUser(Long id) {
        // Check if user exists
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User with ID " + id + " not found");
        }

        // Delete the user and return true if successful
        userRepository.deleteById(id);
        return true;
    }
}
