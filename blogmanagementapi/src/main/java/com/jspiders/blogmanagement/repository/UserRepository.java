package com.jspiders.blogmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.blogmanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByEmailAndPassword(String email, String password);

}
