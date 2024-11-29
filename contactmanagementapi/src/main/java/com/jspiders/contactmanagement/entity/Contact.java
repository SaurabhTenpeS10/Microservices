package com.jspiders.contactmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="contacts")
@Data
public class Contact {
	
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	@Column(nullable = false, unique = false)
	private String name;
	@Column(nullable = false, unique = false)
	private String nickname;
	@Column(nullable = false, unique = true)
	private String email;
	@Id
	@Column(nullable = false, unique = true)
	private long mobile;
	@Column(nullable = false, unique = false)
	private String company;
	@Column(nullable = false, unique = false)
	private String relationship;
	@Column(nullable = false, unique = false)
	private String city;
}
