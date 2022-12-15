package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billService;

	@RequestMapping("/billing")
	public String viewBillGeneration(@RequestParam("id")long id,Model model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "view_bill";
	}
	
	@RequestMapping("/generateBill")
	public String saveBillInfo(@ModelAttribute Billing billing,Model model) {
		billService.saveBill(billing);
		
		List<Billing> bills = billService.findAllBillings();
		model.addAttribute("bills", bills);
		return "bills_list";
	}
	
}
