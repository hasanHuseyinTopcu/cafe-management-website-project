package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Product;

@Repository("ProductDao")
public class ProductDaoImpl extends AbstractDao<Integer,Product> implements ProductDao {

	public Product findById(int id) {
		return getByKey(id);
	}


	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		Criteria criteria = createEntityCriteria();
		return (List<Product>) criteria.list();
	}
	


	public Product findProductByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("productName", name));
		return (Product) criteria.uniqueResult();
	}


	public void deleteProductById(int id) {
		Query query = getSession().createSQLQuery("delete from Products where id ="+id);
		query.executeUpdate();
	}
	
	
	public void saveProduct(Product product) {
		persist(product);		
	}

}
