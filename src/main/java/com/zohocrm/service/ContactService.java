package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Contact;

public interface ContactService {

	void saveOneContact(Contact contact);

	List<Contact> listAllContacts();

	Contact findContactById(long id);

}
