package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Billing;

public interface BillingService {


	void saveBill(Billing billing);

	List<Billing> findAllBillings();

}
