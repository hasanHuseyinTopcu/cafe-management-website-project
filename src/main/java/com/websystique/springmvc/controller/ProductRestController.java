package com.websystique.springmvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.service.ProductService;


@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	//-------------------Retrieve All Product--------------------------------------------------------
    
    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = productService.findAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single product--------------------------------------------------------
     
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        System.out.println("Fetching Product with id " + id);
        Product product = productService.findById(id);
        if (product == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a product--------------------------------------------------------
     
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product product,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Product " + product.getName());
 
        if (productService.isProductExist(product)) {
            System.out.println("A Product with name " + product.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        productService.saveProduct(product);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------------- Update a currentProduct --------------------------------------------------------
     
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        System.out.println("Updating Product " + id);
         
        Product currentProduct = productService.findById(id);
         
        if (currentProduct==null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
 
        currentProduct.setName(product.getName());
        
        productService.updateProduct(currentProduct);
        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Product --------------------------------------------------------
     
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Product with id " + id);
 
        Product product = productService.findById(id);
        if (product == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
 
        productService.deleteProductById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

}
