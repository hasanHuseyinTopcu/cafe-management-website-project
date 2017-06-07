package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.OrderDao;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.model.Order;

@Service("OrderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;

	public Order findById(int id) {
		return dao.findById(id);

	}

	public void saveOrder(Order order) {
		dao.saveOrder(order);
	}

	public List<Order> findAllOrders() {
		return dao.findAllOrders();
	}

	public void updateOrder(Order order) {
		Order entity = dao.findById(order.getId());
		if (entity != null) {
			entity.setStatus("Gonderildi");
		}
	}
	
	public List<Order> findAllOrdersOfACustomer(String username){
		
		List<Order> orders = dao.findAllOrders();
		
		for(int i=0; i<orders.size(); i++){
			
			if(!orders.get(i).getCustomerName().equals(username)){
				orders.remove(i);
				i--;
			}
			
		}
		
		return orders;
	}

}
