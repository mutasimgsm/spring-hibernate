package com.etir.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etir.dao.CustomerDao;
import com.etir.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	// starting data
	List<Customer> customers;

	@PostConstruct
	private void loadData() {

		customers = new ArrayList<>();
		
		customers.add(new Customer("Mutasim", "Younis", "mustsin@yahoo.com"));
		customers.add(new Customer("Zeba", "Mohammed", "zeba@yahoo.com"));
		customers.add(new Customer("Saniya", "Ibrahim", "samiya@yahoo.com"));

	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		
		return customerDao.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		
		customerDao.deleteCustomer(customerId);
	}

}
