package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "Login";
	}
	
	@RequestMapping(value="/CustomerManagement", method = RequestMethod.GET)
	public String getCustomerPage() {
		return "CustomerManagement";
	}
	
	@RequestMapping(value="/ProductManagement", method = RequestMethod.GET)
	public String getProductPage() {
		return "ProductManagement";
	}
	
	@RequestMapping(value="/OrderManagement", method = RequestMethod.GET)
	public String getOrderPage() {
		return "OrderManagement";
	}
	
	@RequestMapping(value="/AccountManagement", method = RequestMethod.GET)
	public String getAccountPage() {
		return "AccountManagement";
	}
	
}