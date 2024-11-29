package com.jspiders.contactmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.contactmanagement.entity.Contact;
import com.jspiders.contactmanagement.service.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public Contact addContact(Contact contact) {
		return contactRepository.save(contact) ;
	}

	public Contact updateContact(Contact contact) {
		return contactRepository.save(contact);
	}

	public Contact findContactByMobile(long mobile) {
		return contactRepository.findContactByMobile(mobile);
	}

	public Contact findContactByMobileId(long mobile) {
		 Optional<Contact> contact = contactRepository.findById(mobile);
		 if(contact.isPresent()) {
			 return contact.get();
		 }
		 return null;
	}

	public List<Contact> findAllContacts() {
		return contactRepository.findAll();
	}

	public List<Contact> searchContact(String searchString) {
		
		 return contactRepository.findByEmailOrNicknameOrRelationshipOrCompanyOrCity(
		            searchString, searchString, searchString, searchString, searchString);
	}
	
	 
	    public List<Contact> searchByMultipleFields(String searchString){
	    	return contactRepository.searchByMultipleFields(searchString);
	    }
	

}
