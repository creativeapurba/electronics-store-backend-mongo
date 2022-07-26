package com.electronstore.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electronstore.springboot.model.Product;
import com.electronstore.springboot.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// C - Create
	@PostMapping("products")
	public String addOrUpdateProduct(@RequestBody Product product){
		
		productService.addOrUpdateProduct(product);
		return "success";
	}
	
	// R - Read
	@GetMapping("products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("products/{productId}")
	public Optional<Product> getProductById(@PathVariable int productId) {
		return productService.getProductById(productId);
	}
	
	//U - Update
	@PutMapping("products/{productId}")
	public Product updateProduct(@PathVariable int productId, @RequestBody Product product){
		Product p = null;
		try {
			p = productService.getProductById(productId).orElseThrow(() -> new Exception("product not exist with id: " + productId));
			p.setCategory(product.getCategory());
	        p.setProductName(product.getProductName());
	        p.setPrice(product.getPrice());
	
	        productService.addOrUpdateProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	// D - Delete
	@DeleteMapping("products/{productId}")  
	private void deleteProductbyId(@PathVariable int productId)   {  
		this.productService.deleteProductById(productId);   
	}
}
