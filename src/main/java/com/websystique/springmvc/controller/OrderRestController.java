package com.websystique.springmvc.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.model.Order;
import com.websystique.springmvc.service.CustomerService;
import com.websystique.springmvc.service.OrderService;


@RestController
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	//-------------------Retrieve All Orders--------------------------------------------------------
    
    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAllOrders() {
        List<Order> orders = orderService.findAllOrders();
        if(orders.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
    
    
    //-------------------Retrieve All Orders of one Customer--------------------------------------------------------
    
    @RequestMapping(value = "/order/of/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAllOrdersOfACustomer(@PathVariable("username") String username) {
    	
    	
    	
        List<Order> orders = orderService.findAllOrdersOfACustomer(username);
        if(orders.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
    
    //-------------------Retrieve Unique Customers-----------------------------------------------------
    @RequestMapping(value = "/order/uniqueCustomers/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listOfCustomers() {
        List<Customer> customers = customerService.findAllCustomer();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        
        List<Customer> asd = customerService.findAllCustomer();
        
        asd.clear();
        
        for(int i=0; i<customers.size(); i++){
        	if(!asd.contains(customers.get(i)))
        		asd.add(customers.get(i));
        }
        
        for(Customer c : asd)
        	System.out.println(c.getUsername());
        
        return new ResponseEntity<List<Customer>>(asd, HttpStatus.OK);
    }
 
    
    //-------------------Retrieve Single Order--------------------------------------------------------
    
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("id") int id) {
        System.out.println("Fetching Order with id " + id);
        Order order = orderService.findById(id);
        if (order == null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    //--------------Retrieve orders according to signed customer-----------------------------
     
    @RequestMapping(value = "/customer/getOrders", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listOrderInSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        int customerID = Integer.parseInt(session.getAttribute("loggedInUser").toString());
        List<Order> allOrders = orderService.findAllOrders();
        List<Order> orders = orderService.findAllOrders();
        orders.clear();
        for (Order order : allOrders) {
        	if(order.getCustomerID() == customerID){
        		orders.add(order);
        	}		
		}
        for (Order order : orders) {
			System.out.println(order.getProductName());
		}
        if(orders.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }
    
    
    //-------------------Create a Order--------------------------------------------------------
     
    @RequestMapping(value = "/order/", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody Order order,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Order " + order.getId());
 
        String dateTime = order.getCreatedDate();
        
        dateTime = dateTime.replace('T', ' ');
        
        dateTime = dateTime.substring(0, 19);
        
        System.out.println(dateTime);
        
        order.setCreatedDate(dateTime);

        orderService.saveOrder(order);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------------- Update a Order's status "yeni" to "gonderildi" --------------------------------------------------------
     
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@PathVariable("id") int id, @RequestBody Order order) {
        System.out.println("Updating Order " + id);
         
        Order currentOrder = orderService.findById(id);
         
        if (currentOrder==null) {
            System.out.println("ORder with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        
        currentOrder.setStatus("gonderildi");
        
        orderService.updateOrder(currentOrder);
        
        return new ResponseEntity<Order>(currentOrder, HttpStatus.OK);
    }

}
