package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	//Need to inject te customer service 
	@Autowired
	private CustomerService customerService;
	
	//Create a list with a model
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
	
		//get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model 
		
		theModel.addAttribute("customers", theCustomers);
		
		//Target a jsp file
		return "list-customers";
	}
	
	
	//Add the "Add customer link"
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//Create a model attrb to bind form data 
		Customer theCustomer = new Customer();
		
		//attrb: name, value
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}

	//Retrieve data from the customer form: "saveCustomers"
	@PostMapping("/saveCustomer") //Add the attributes to the model
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using the service 
		customerService.saveCustomer(theCustomer);
		
		//Send user back to main page
		return "redirect:/customer/list";
	}

}
