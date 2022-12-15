package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.service.ContactService;
import com.zohocrm.service.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;

	//http://localhost:8080/create
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping(value="/createLead" , method=RequestMethod.POST)
	public String createOneLead(@ModelAttribute("l") Lead lead,Model model) {
		leadService.saveOneLead(lead);
		model.addAttribute("msg", "data saved!!");
		model.addAttribute("lead", lead);
		return "lead_Info";
	}
	
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String listLeads(Model model) {
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/leadInfo")
	public String getLeadInfo(@RequestParam("id")long id,Model model) {
		Lead lead = leadService.getLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_Info";
	}
	
	@RequestMapping("/Convert")
	public String convertToContact(@RequestParam("id")long id,Model model) {
		Lead lead = leadService.getLeadById(id);
		
		Contact contact=new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveOneContact(contact);
		leadService.deleteOneLead(lead);
		
		List<Contact> contacts = contactService.listAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
		
	}
	
	
	
	
}
