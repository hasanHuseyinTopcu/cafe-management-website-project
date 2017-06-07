package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Order;

public interface OrderDao {

	Order findById(int id);

	void saveOrder(Order order);
	
	List<Order> findAllOrders();

}
