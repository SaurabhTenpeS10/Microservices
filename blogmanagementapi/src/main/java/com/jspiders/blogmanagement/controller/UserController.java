package com.jspiders.blogmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.blogmanagement.entity.Response;
import com.jspiders.blogmanagement.entity.Role;
import com.jspiders.blogmanagement.entity.User;
import com.jspiders.blogmanagement.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/signup")
	private ResponseEntity<Response<User>> signUp(@RequestBody User user){

		User addedUser =	userService.addUser(user);
		Response<User> response = new Response<>();
		if(addedUser != null) {
			response.setMessage("User Added Successfully \n Login Here");
			response.setData(addedUser);
			response.setHttpStatusCode(HttpStatus.CREATED.value());
			
			return new ResponseEntity<Response<User>>(response, HttpStatus.CREATED);
		} else {
			response.setMessage("Something went Wrong! Sign Up Again");
			response.setHttpStatusCode(HttpStatus.NOT_IMPLEMENTED.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.NOT_IMPLEMENTED);
		}
		
	}
	
	@PostMapping(value="/login")
	private ResponseEntity<Response<User>> login(@RequestBody User user){
		User loginUser = userService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		Response<User> response = new Response<>();
		if(loginUser != null) {
			if(loginUser.getRole() == Role.ADMIN) {
				response.setMessage("Welcome to Admin Home Page");
			} else {
				response.setMessage("Welcome to Home Page");
			}
			response.setData(loginUser);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.FOUND);
			
		} else {
			response.setMessage("Email or Password is Wrong! Please try again..");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/update-user")
	protected ResponseEntity<Response<User>> updateUser(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		Response<User> response = new Response<>();
		if(updatedUser != null) {
			response.setMessage("User Updated Successfully");
			response.setData(updatedUser);
			response.setHttpStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.CREATED);
		} else {
			  response.setMessage("User Update Failed");
			    response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			    return new ResponseEntity<Response<User>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="delete-user")
	protected ResponseEntity<Response<User>> deleteUser(@RequestParam (name="id") int id){
		User deletedUser = userService.deleteUser(id);
		Response<User> response = new Response<>();
		if(deletedUser != null) {
			response.setMessage("Account Deleted!");
			response.setData(deletedUser);
			response.setHttpStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.OK);
		} else {
			response.setMessage("Account Not Deleted!");
			response.setData(deletedUser);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="find-user")
	protected ResponseEntity<Response<User>> findUserById(@RequestParam int id){
		User user = userService.findUserById(id);
		Response<User> response = new Response<>();
		if(user != null) {
			response.setMessage("User Found");
			response.setData(user);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("User Not Found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/users")
	protected ResponseEntity<Response<List<User>>> findAllUsers(){
		List<User> users =  userService.findAllUsers();
		Response<List<User>> response = new Response<>();
		if(users.size()>0) {
			response.setMessage("All Users");
			response.setData(users);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<List<User>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("Users not Found..");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<List<User>>>(response, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PatchMapping(value = "/map-blogs")
	protected ResponseEntity<Response<User>> mapBlogToUser(@RequestParam(name = "user_id") int userId,
			@RequestParam(name = "blog_id") int productId) {
		User user = userService.mapBlogToUser(userId, productId);
		Response<User> response = new Response<>();
		response.setMessage("Product mapped to user");
		response.setHttpStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<Response<User>>(response, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
