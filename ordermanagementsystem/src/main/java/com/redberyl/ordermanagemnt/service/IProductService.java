package com.redberyl.ordermanagemnt.service;

import com.redberyl.ordermanagemnt.model.Product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IProductService {
	
    Product addProduct(Product product);
    
    List<Product> getAllProducts();
    
    Product getProductById(Long id);
    
    Product updateProduct(Long id, Product productDetails);
    
    boolean deleteProduct(Long id);
}
