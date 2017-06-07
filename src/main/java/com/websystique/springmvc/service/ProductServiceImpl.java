package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ProductDao;
import com.websystique.springmvc.model.Product;


@Service("ProductService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao dao;
	
	public Product findById(int id) {
		return dao.findById(id);
	}

	public List<Product> findAllProducts() {
		return dao.findAllProducts();
	}

	public Product findProductByName(String name) {
		return null;
	}

	public void updateProduct(Product product) {
		Product entity = dao.findById(product.getId());
		if(entity!=null){
			entity.setName(product.getName());
		}
	}

	public void saveProduct(Product product) {
		dao.saveProduct(product);
	}

	public void deleteProductById(int id) {
		dao.deleteProductById(id);
	}
	
	public boolean isProductExist(Product product) {
		return findProductByName(product.getName())!=null;
	}

}
