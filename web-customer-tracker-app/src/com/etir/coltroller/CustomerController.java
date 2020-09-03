package com.etir.coltroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etir.entity.Customer;
import com.etir.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// add an initbinder ... to convert trim input string
	// remove leading and trailing whitespace
	// resolve issue for our validation
	@InitBinder
	public void iniBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String getCustomers(Model model) {

		List<Customer> customers = customerService.getCustomers();

		// add customer to model
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/addForm")
	public String addCustomer(Model model) {

		model.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("/submitCustomer")
	public String submitCustomer(@ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

		System.out.println("Customer: " + customer);

		if (customer.getFirstName() != null || customer.getEmail() != null || customer.getLastName() != null) {
			customerService.saveCustomer(customer);
			return "redirect:/customer/list";
		} else {
			return "customer-form";
		}
	}

	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int customerId, Model model) {

		System.out.println("customerId: " + customerId);

		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCusotmer(@RequestParam("customerId") int customerId) {

		System.out.println("customerId: " + customerId);

		customerService.deleteCustomer(customerId);

		return "redirect:/customer/list";
	}
}
