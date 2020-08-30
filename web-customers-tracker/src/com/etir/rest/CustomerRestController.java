package com.etir.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etir.entity.Customer;
import com.etir.exception.CustomerNotFoundException;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	List<Customer> customers;

	@PostConstruct
	private void loadData() {
		customers = new ArrayList<>();

		customers.add(new Customer("Mutasim", "Younis", "mutasim@yahoo.com"));
		customers.add(new Customer("Zeba", "Mohammed", "zeba@yahoo.com"));
		customers.add(new Customer("Omer", "Awad", "omer@yahoo.com"));
	}

	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customers;
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCutomer(@PathVariable int customerId) {

		// check the studentId against list size

		if ((customerId >= customers.size()) || (customerId < 0)) {
			throw new CustomerNotFoundException("Customer id not found " + customerId);
		}

		return customers.get(customerId);
	}


}
