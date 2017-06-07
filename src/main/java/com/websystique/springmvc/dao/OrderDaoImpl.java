package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Order;


@Repository("OrderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

	public Order findById(int id) {
		return getByKey(id);
	}

	public void saveOrder(Order order) {
		persist(order);
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> findAllOrders() {
		Criteria criteria = createEntityCriteria();
		return (List<Order>) criteria.list();
	}
}
