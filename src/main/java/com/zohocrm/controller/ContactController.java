package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	//http://localhost:8080/listContacts
	@RequestMapping("/listContacts")
	public String listContacts(Model model) {
		List<Contact> contacts = contactService.listAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
	
	@RequestMapping("/contactInfo")
	public String contactInfo(@RequestParam("id")long id,Model model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_Info";
	}
	
	
	
	
}
