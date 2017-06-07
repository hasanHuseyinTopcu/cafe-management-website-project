package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Product;

public interface ProductDao {

	Product findById(int id);

	void saveProduct(Product product);

	List<Product> findAllProducts();

	void deleteProductById(int id);

	Product findProductByName(String name);

}
