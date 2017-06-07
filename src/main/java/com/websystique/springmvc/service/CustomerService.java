package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Customer;

public interface CustomerService {

	Customer findById(int id);

	void deleteCustomerById(int id);

	void saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	List<Customer> findAllCustomer();

	Customer findCustomerByName(String name);
	
	public boolean isCustomerExist(Customer customer);
}
