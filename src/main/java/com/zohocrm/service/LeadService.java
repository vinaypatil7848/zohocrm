package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Lead;

public interface LeadService {

	void saveOneLead(Lead lead);

	List<Lead> findAllLeads();

	Lead getLeadById(long id);

	void deleteOneLead(Lead lead);

}
