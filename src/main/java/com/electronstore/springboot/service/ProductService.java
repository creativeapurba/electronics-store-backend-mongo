package com.electronstore.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronstore.springboot.model.Product;
import com.electronstore.springboot.model.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product addOrUpdateProduct(Product product) {
		return productRepository.save(product); 
	}
	
	public List<Product> getAllProducts(){		
		return productRepository.findAll();	
	}

	public Optional<Product> getProductById(int productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	public void deleteProductById(int productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
		
	}
}
