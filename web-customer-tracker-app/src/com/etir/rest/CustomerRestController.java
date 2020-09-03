package com.etir.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etir.entity.Customer;
import com.etir.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> getCustomers() {
		

		return  customerService.getCustomers();
	}

}
