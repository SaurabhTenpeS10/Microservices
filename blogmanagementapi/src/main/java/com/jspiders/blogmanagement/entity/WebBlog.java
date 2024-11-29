package com.jspiders.blogmanagement.entity;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="blogs")
@Data
public class WebBlog implements Comparable<WebBlog> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String title;
	@Column(nullable = false, unique = false)
	private String content;
	@Column(nullable = false, unique = false)
	private Date date;
	@Column(nullable = false, unique = false)
	private String author;
	@Column(nullable = false, unique = false)
	private int userId;
	
	@Override
	public int compareTo(WebBlog o) {
		if (this.date.after(o.date)) {
			return 1;
		} else if (this.date.before(o.date)) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
