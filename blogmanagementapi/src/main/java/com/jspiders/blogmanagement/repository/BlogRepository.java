package com.jspiders.blogmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.blogmanagement.entity.WebBlog;

@Repository
public interface BlogRepository extends JpaRepository<WebBlog, Integer> {
    List<WebBlog> findAllBlogsByUserId(int userId);
}
