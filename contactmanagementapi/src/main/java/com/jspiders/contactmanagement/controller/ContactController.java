package com.jspiders.contactmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.contactmanagement.entity.Contact;
import com.jspiders.contactmanagement.entity.Response;
import com.jspiders.contactmanagement.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping(value="/add-contact")
	protected ResponseEntity<Response<Contact>> addContact(@RequestBody Contact contact) {
		Contact addedContact = contactService.addContact(contact);
		Response<Contact> response = new Response<>();
		if(addedContact != null) {
			response.setMessage("Contact Added");
			response.setData(addedContact);
			response.setHttpStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.CREATED);
		} else {
			response.setMessage("Something went Wrong..");
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="/update-contact")
	protected ResponseEntity<Response<Contact>> updateContact(@RequestBody Contact contact){
		Contact updatedContact =  contactService.updateContact(contact);
		Response<Contact> response = new Response<>();
		if(updatedContact != null) {
			response.setMessage("Contact Updated");
			response.setData(updatedContact);
			response.setHttpStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.CREATED);
		} else {
			response.setMessage("Something went Wrong..");
			response.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping(value="/find-contact")
	protected ResponseEntity<Response<Contact>> findContactByMobile(@RequestParam  long mobile ){
		Contact contact = contactService.findContactByMobile(mobile);
		Response<Contact> response = new Response<>();
		if(contact != null) {
			response.setMessage("Contact Details");
			response.setData(contact);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("Invalid Mobile Number..");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value="/find-contact")
	protected ResponseEntity<Response<Contact>> findContactByMobileId(@RequestParam long mobile ){
		Contact contact = contactService.findContactByMobileId(mobile);
		Response<Contact> response = new Response<>();
		if(contact != null) {
			response.setMessage("Contact Details");
			response.setData(contact);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("Something went Wrong..");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<Contact>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/find-contacts")
	protected ResponseEntity<Response<List<Contact>>> findAllContacts(){
		List<Contact> contacts = contactService.findAllContacts();
		Response<List<Contact>> response = new Response<>();
		if(contacts.size()>0) {
			response.setMessage("All Contacts");
			response.setData(contacts);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<List<Contact>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("Something went Wrong..");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<List<Contact>>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/search")
	protected ResponseEntity<Response<List<Contact>>> searchContact(
			@RequestParam(name = "search") String searchString) {
		List<Contact> contacts = contactService.searchContact(searchString);
		Response<List<Contact>> response = new Response<>();
		if (contacts.size() > 0) {
			response.setMessage("Searched Contacts are: ");
			response.setData(contacts);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<List<Contact>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("No Contacts Found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<List<Contact>>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/search")
	protected ResponseEntity<Response<List<Contact>>> searchContactsByMultipleFields(
			@RequestParam(name = "search") String searchString) {
		List<Contact> contacts = contactService.searchByMultipleFields(searchString);
		Response<List<Contact>> response = new Response<>();
		if (contacts.size() > 0) {
			response.setMessage("Searched Contacts are: ");
			response.setData(contacts);
			response.setHttpStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Response<List<Contact>>>(response, HttpStatus.FOUND);
		} else {
			response.setMessage("No Contacts Found");
			response.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Response<List<Contact>>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
}






















