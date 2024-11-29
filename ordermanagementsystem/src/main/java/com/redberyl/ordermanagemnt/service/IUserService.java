package com.redberyl.ordermanagemnt.service;

import com.redberyl.ordermanagemnt.model.User;
import java.util.List;

public interface IUserService {

    // Add a new user
    User addUser(User user);

    // Find all users
    List<User> findAllUsers();

    // Find a user by ID
    User findUserById(Long id);

    // Find a user by email and password
    User findUserByEmailAndPassword(String email, String password);

    // Update user details
    User updateUser(Long id, User userDetails);

    // Delete a user by ID
    boolean deleteUser(Long id);
}
