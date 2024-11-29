package com.jspiders.blogmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.blogmanagement.entity.User;
import com.jspiders.blogmanagement.entity.WebBlog;
import com.jspiders.blogmanagement.repository.BlogRepository;
import com.jspiders.blogmanagement.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository webBlogRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User findUserByEmailAndPassword(String email, String password) {
		return userRepository.findUserByEmailAndPassword(email,password);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User findUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}  
		
	}

	public User deleteUser(int id) {
		User user = userRepository.findById(id).get();
		userRepository.deleteById(id);
		return user;
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User mapBlogToUser(int userId, int productId) {
		User user = userRepository.findById(userId).get();
		WebBlog blog = webBlogRepository.findById(productId).get();
		List<WebBlog> blogs = user.getBlogs();
		blogs.add(blog);
		user.setBlogs(blogs);
		return userRepository.save(user);
	}
}
