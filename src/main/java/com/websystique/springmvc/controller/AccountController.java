package com.websystique.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.service.CustomerService;


@Controller
public class AccountController {

		@Autowired
		private CustomerService customerService;
	
	
	 
		@RequestMapping(value = {"/", "/Login"} )
		public ModelAndView loginAdmin(ModelAndView model) {
	        return new ModelAndView("/Login");
	    }
		
		@RequestMapping(value="executeLogin", method=RequestMethod.POST)
		public ModelAndView executeAdminLogin(HttpServletRequest request){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals("admin") && password.equals("admin")){
				return new ModelAndView("redirect:/CustomerManagement");
			}else{
				ArrayList<Customer> customerList = (ArrayList<Customer>) customerService.findAllCustomer();
				HttpSession session = request.getSession();
				for (Customer customer : customerList) {
					if(customer.getUsername().equals(username) && customer.getPassword().equals(password)){
						session.setAttribute("loggedInUser", customer.getId());
						return new ModelAndView("redirect:/AccountManagement");
					}
				}
				
				return new ModelAndView("redirect:/Login");
			}
			
		}
}
