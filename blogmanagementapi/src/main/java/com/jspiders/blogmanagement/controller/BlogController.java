package com.jspiders.blogmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.blogmanagement.entity.Response;
import com.jspiders.blogmanagement.entity.WebBlog;
import com.jspiders.blogmanagement.service.BlogService;

@RestController
public class BlogController {

	@Autowired
	private BlogService webBlogService;


	@PostMapping(value = "/add-blog")
	protected ResponseEntity<Response<WebBlog>> addBlog(@RequestBody WebBlog blog) {
		blog.setDate(new Date(System.currentTimeMillis()));
		WebBlog addedBlog = webBlogService.addBlog(blog);
		Response<WebBlog> response = new Response<>();
		if (addedBlog != null) {
			response.setMessage("Blog Added Successfully!");
			response.setData(addedBlog);
			response.setHttpStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<Response<WebBlog>>(response, HttpStatus.CREATED);
		} else {
			response.setMessage("Blog not Added! Please try again..");
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<Response<WebBlog>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/blogs")
	protected ResponseEntity<Response<List<WebBlog>>> findAllBlogs() {
		List<WebBlog> blogs = webBlogService.findAllBlogs();
		Response<List<WebBlog>> response = new Response<>();
		if (blogs.size() > 0) {
			response.setMessage("All Blogs");
			response.setData(blogs);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<List<WebBlog>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("No Blog found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<List<WebBlog>>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/my-blogs")
	protected ResponseEntity<Response<List<WebBlog>>> findMyBlogs(@RequestParam(name = "id") int userId) {
		List<WebBlog> myBlogs = webBlogService.findMyBlogs(userId);
		Response<List<WebBlog>> response = new Response<>();
		if (!myBlogs.isEmpty()) {
			response.setMessage("My Blogs");
			response.setData(myBlogs);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<List<WebBlog>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("No Blog found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<List<WebBlog>>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "/update-blog")
	protected ResponseEntity<Response<WebBlog>> updateBlog(@RequestBody WebBlog blog) {
		blog.setDate(new Date(System.currentTimeMillis()));
		WebBlog updatedBlog = webBlogService.updateBlog(blog);
		Response<WebBlog> response = new Response<>();
		if (updatedBlog != null) {
			response.setMessage("Blog Updated");
			response.setData(updatedBlog);
			response.setHttpStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<Response<WebBlog>>(response, HttpStatus.CREATED);
		} else {
			response.setMessage("Something Went Wrong..");
			response.setData(updatedBlog);
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<Response<WebBlog>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/delete-blog")
	protected ResponseEntity<Response<WebBlog>> deleteBlog(@RequestParam(name="user_id") int userId, 
															@RequestParam(name="blog_id") int blogId){
		WebBlog deletedBlog = webBlogService.deleteBlog(userId,blogId);
		Response<WebBlog> response = new Response<>();
		if(deletedBlog != null) {
			response.setMessage("Blog Deleted");
			response.setData(deletedBlog);
			response.setHttpStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<Response<WebBlog>>(response, HttpStatus.OK);
		} else {
			response.setMessage("Blog Deleted");
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<Response<WebBlog>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/sort-blogs")
	protected ResponseEntity<Response<List<WebBlog>>> sortBlogs(@RequestParam int index){
		List<WebBlog> blogs =  webBlogService.sortBlogs(index);
		Response<List<WebBlog>> response = new Response<>();
		if(blogs.size()>0) {
			if(index == 1)
				response.setMessage("Sort By Newest Blog First");
			else
				response.setMessage("Sort By Oldest Blog First");
			response.setData(blogs);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<List<WebBlog>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("No Blogs Found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<List<WebBlog>>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
