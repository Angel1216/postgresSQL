package com.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public List<Customer> findByLastName(String lastName); 
}
