package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.CustomerDao;
import com.websystique.springmvc.model.Customer;

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	

	@Autowired
	@Qualifier("CustomerDao")
	private CustomerDao dao;
	
	public Customer findById(int id) {
		return dao.findById(id);
	}

	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);	
	}

	
	public void updateCustomer(Customer customer) {
		Customer entity = dao.findById(customer.getId());
		if(entity!=null){
			entity.setPassword(customer.getPassword());
			entity.setFirstName(customer.getFirstName());
			entity.setLastName(customer.getLastName());
			entity.setFloorNo(customer.getFloorNo());
			entity.setBuildingNo(customer.getBuildingNo());
			entity.setRoomNo(customer.getRoomNo());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomer() {
		return dao.findAllCustomer();
	
	}

	public Customer findCustomerByName(String customerName) {
		return dao.findCustomerByName(customerName);
	}

	public void deleteCustomerById(int id) {
		dao.deleteCustomerById(id);
	}
	
	public boolean isCustomerExist(Customer customer) {
		return findCustomerByName(customer.getUsername())!=null;
	}

}
