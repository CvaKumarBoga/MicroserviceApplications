package com.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Customer;
import com.app.repo.CustomerRepository;
import com.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repo;

	@Transactional
	@Override
	public Integer saveData(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer).getCustomerId();
	}
	
	

}
