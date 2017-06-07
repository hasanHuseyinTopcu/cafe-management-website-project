package com.websystique.springmvc.service;

import java.util.List;


import com.websystique.springmvc.model.Product;

public interface ProductService {

	Product findById(int id);
	
	void deleteProductById(int id);

	void saveProduct(Product product);

	void updateProduct(Product product);
	
	List<Product> findAllProducts();

	Product findProductByName(String name);

	public boolean isProductExist(Product product);
	
}
