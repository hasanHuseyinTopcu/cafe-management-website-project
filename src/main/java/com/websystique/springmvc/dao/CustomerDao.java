package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Customer;

public interface CustomerDao {

	Customer findById(int id);
	
	void deleteCustomerById(int id);
	
	void saveCustomer(Customer customer);
		
	List<Customer> findAllCustomer();

	Customer findCustomerByName(String name);

}
