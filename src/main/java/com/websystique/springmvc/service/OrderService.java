package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Order;

public interface OrderService {

	Order findById(int id);

	void saveOrder(Order order);

	public void updateOrder(Order order);

	List<Order> findAllOrders();
	
	List<Order> findAllOrdersOfACustomer(String username);

}
