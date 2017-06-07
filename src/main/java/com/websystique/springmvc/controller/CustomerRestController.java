package com.websystique.springmvc.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.service.CustomerService;


@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	//-------------------Retrieve All Customers--------------------------------------------------------
    
    @RequestMapping(value = "/customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> customers = customerService.findAllCustomer();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/customer/getCustomer/", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(HttpServletRequest request) {
        
    	
        HttpSession session = request.getSession();
        
        int customerId = Integer.parseInt(session.getAttribute("loggedInUser").toString());
        
        Customer customer = customerService.findById(customerId);
        
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
   
    //-------------------Retrieve Single Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + customer.getUsername());
 
        if (customerService.isCustomerExist(customer)) {
            System.out.println("A Customer with name " + customer.getUsername() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        customerService.saveCustomer(customer);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------------- Update a currentCustomer --------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + id);
         
        Customer currentCustomer = customerService.findById(id);
         
        if (currentCustomer==null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
 
        currentCustomer.setPassword(customer.getPassword());
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName()); 
        currentCustomer.setBuildingNo(customer.getBuildingNo());
        currentCustomer.setFloorNo(customer.getFloorNo());
        currentCustomer.setRoomNo(customer.getRoomNo());
        
        customerService.updateCustomer(currentCustomer);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Customer with id " + id);
 
        Customer customer = customerService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
 
        customerService.deleteCustomerById(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }

}
