package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;

@RestController
public class WebController {
	
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/save")
	public String process() {
		repository.save(new Customer("Jack", "Smith"));
		repository.save(new Customer("Adam", "Johnson"));
		repository.save(new Customer("Kim", "Smith"));
		repository.save(new Customer("David", "Williams"));
		repository.save(new Customer("Peter", "Davis"));
		return "Done"; 
	}
	
	@RequestMapping("/findall")
	public String findAll() {
		String result = "<html>";
		
		for(Customer cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid/{id}")
	public String findbyid(@PathVariable("id") Long id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbylastname")
	public String findByLastName(@RequestParam("lastname") String lastname) {
		String result = "<html>";
		
		for(Customer cust : repository.findByLastName(lastname)) {
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
}