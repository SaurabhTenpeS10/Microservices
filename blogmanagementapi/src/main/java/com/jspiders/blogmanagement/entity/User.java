package com.jspiders.blogmanagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String username;
	@Column(nullable = false, unique = false)
	private Role role;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private long mobile;
	@Column(nullable = false, unique = false)
	private String password;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<WebBlog> blogs;
	
}
