package com.jspiders.contactmanagement.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jspiders.contactmanagement.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	Contact findContactByMobile(long mobile);

//	List<Contact> searchByMultipleFields(String searchString);
	
	 // Search across multiple fields using derived query method
    List<Contact> findByEmailOrNicknameOrRelationshipOrCompanyOrCity(
        String email, String nickname, String relationship, String company, String city);
    
    @Query("SELECT c FROM Contact c WHERE " +
            "LOWER(c.email) LIKE LOWER(CONCAT('%', :searchString, '%')) OR " +
            "LOWER(c.nickname) LIKE LOWER(CONCAT('%', :searchString, '%')) OR " +
            "LOWER(c.relationship) LIKE LOWER(CONCAT('%', :searchString, '%')) OR " +
            "LOWER(c.company) LIKE LOWER(CONCAT('%', :searchString, '%')) OR " +
            "LOWER(c.city) LIKE LOWER(CONCAT('%', :searchString, '%'))")
     List<Contact> searchByMultipleFields(String searchString);



}
