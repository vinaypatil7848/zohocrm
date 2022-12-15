package com.zohocrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Billing;
import com.zohocrm.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingRepository billRepo;


	@Override
	public void saveBill(Billing billing) {
		billRepo.save(billing);
	}


	@Override
	public List<Billing> findAllBillings() {
		List<Billing> bill = billRepo.findAll();
		return bill;
	}

}
