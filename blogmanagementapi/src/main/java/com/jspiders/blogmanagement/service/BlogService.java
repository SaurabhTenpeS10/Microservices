package com.jspiders.blogmanagement.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.blogmanagement.entity.User;
import com.jspiders.blogmanagement.entity.WebBlog;
import com.jspiders.blogmanagement.repository.BlogRepository;
import com.jspiders.blogmanagement.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository webBlogRepository;
	@Autowired
	private UserRepository userRepository;

	public WebBlog addBlog(WebBlog blog) {
		return webBlogRepository.save(blog);
	}

	public List<WebBlog> findAllBlogs() {
		
		return webBlogRepository.findAll();
	}

	public List<WebBlog> findMyBlogs(int userId) {
	    List<WebBlog> blogs = webBlogRepository.findAllBlogsByUserId(userId);
	    Optional<User> optionalUser = userRepository.findById(userId);
	    
	    if(optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        user.setBlogs(blogs);
	        userRepository.save(user);
	    }
	    
	    return blogs;
	}

	public WebBlog updateBlog(WebBlog blog) {
		return webBlogRepository.save(blog);
	}

	public WebBlog findBlogId(int blogId) {
		Optional<WebBlog> blog = webBlogRepository.findById(blogId);
		if(blog.isPresent()) {
			return blog.get();
		}
		return null;
	}

	public WebBlog deleteBlog(int userId, int blogId) {
		User user = userRepository.findById(userId).get();
		WebBlog blog = webBlogRepository.findById(blogId).get();
		List<WebBlog> blogs = user.getBlogs();
		WebBlog blogToBeDeleted = null;
		for(WebBlog b : blogs) {
			if(blogId == b.getId()) {
				blogToBeDeleted = b;
			}
		}
		blogs.remove(blogToBeDeleted);
		user.setBlogs(blogs);
		userRepository.save(user);
		webBlogRepository.delete(blog);
		return blog;
	}

	public List<WebBlog> sortBlogs(int index) {
		List<WebBlog> blogs = webBlogRepository.findAll();
		Collections.sort(blogs);
		if(index==1) {
			Collections.reverse(blogs);
			return blogs;
		} else {
		return blogs;
		}
	}


}
