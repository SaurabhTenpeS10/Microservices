package com.redberyl.ordermanagemnt.controller;

import com.redberyl.ordermanagemnt.dto.Response;
import com.redberyl.ordermanagemnt.model.User;
import com.redberyl.ordermanagemnt.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "User Management APIs",
        description = "APIs for managing users, including registration, login, logout, and CRUD operations."
)
@RestController
@RequestMapping("/api/users")
@Validated
@AllArgsConstructor
public class UserController {

    private final IUserService iUserService;

    /**
     * API: Register a new user
     */
    @Operation(
            summary = "Register a new user",
            description = "Registers a new user and returns the created user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "User registered successfully",
                    content = @Content(schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed"
            )
    })
    @PostMapping("/signup")
    public ResponseEntity<Response<User>> signUp(@Valid @RequestBody User user) {
        User addedUser = iUserService.addUser(user);
        Response<User> response = new Response<>();
        if (addedUser != null) {
            response.setMessage("User added successfully.");
            response.setData(addedUser);
            response.setHttpStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setMessage("Sign-up failed. Please try again.");
            response.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * API: User Login
     */
    @Operation(
            summary = "Authenticate a user",
            description = "Logs in a user with the provided email and password."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Login successful",
                    content = @Content(schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Invalid email or password"
            )
    })
    @PostMapping("/login")
    public ResponseEntity<Response<User>> login(
            @RequestParam @NotEmpty(message = "Email cannot be empty") String email,
            @RequestParam @NotEmpty(message = "Password cannot be empty") String password) {
        User loginUser = iUserService.findUserByEmailAndPassword(email, password);
        Response<User> response = new Response<>();
        if (loginUser != null) {
            response.setMessage("Login successful.");
            response.setData(loginUser);
            response.setHttpStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage("Invalid email or password.");
            response.setHttpStatusCode(HttpStatus.UNAUTHORIZED.value());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * API: Get All Users
     */
    @Operation(
            summary = "Retrieve all users",
            description = "Fetch a list of all registered users."
    )
    @GetMapping
    public ResponseEntity<Response<List<User>>> getAllUsers() {
        List<User> users = iUserService.findAllUsers();
        Response<List<User>> response = new Response<>();
        if (!users.isEmpty()) {
            response.setMessage("All users found.");
            response.setData(users);
            response.setHttpStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage("No users found.");
            response.setHttpStatusCode(HttpStatus.NO_CONTENT.value());
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * API: Get User by ID
     */
    @Operation(
            summary = "Retrieve a user by ID",
            description = "Fetch the details of a specific user by their ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<Response<User>> getUserById(@PathVariable Long id) {
        User user = iUserService.findUserById(id);
        Response<User> response = new Response<>();
        if (user != null) {
            response.setMessage("User found.");
            response.setData(user);
            response.setHttpStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage("User not found.");
            response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * API: Update User
     */
    @Operation(
            summary = "Update user details",
            description = "Modify the details of an existing user."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Response<User>> updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
        User updatedUser = iUserService.updateUser(id, user);
        Response<User> response = new Response<>();
        if (updatedUser != null) {
            response.setMessage("User updated successfully.");
            response.setData(updatedUser);
            response.setHttpStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setMessage("User not found.");
            response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * API: Delete User
     */
    @Operation(
            summary = "Delete a user",
            description = "Remove a user by their ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteUser(@PathVariable Long id) {
        boolean isDeleted = iUserService.deleteUser(id);
        Response<Void> response = new Response<>();
        if (isDeleted) {
            response.setMessage("User deleted successfully.");
            response.setHttpStatusCode(HttpStatus.NO_CONTENT.value());
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.setMessage("User not found.");
            response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
