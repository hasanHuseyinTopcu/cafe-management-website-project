package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Customer;

@Repository("CustomerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	public Customer findById(int id) {
		return getByKey(id);
	}

	public void saveCustomer(Customer customer) {
		persist(customer);	
	}

	
	public void deleteCustomerById(int id) {
		
		Query query = getSession().createSQLQuery("delete from Customers where id ="+id);
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomer() {
		Criteria criteria = createEntityCriteria();
		return (List<Customer>) criteria.list();
	
	}
	
	

	public Customer findCustomerByName(String customerName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("firstName", customerName));
		return (Customer) criteria.uniqueResult();
	}
	
}
