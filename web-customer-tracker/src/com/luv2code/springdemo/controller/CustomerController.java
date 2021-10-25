package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//Create a list with a model
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		//Target a jsp file
		return "list-customers";
	}
	
	
}
