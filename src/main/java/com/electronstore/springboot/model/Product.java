package com.electronstore.springboot.model;

import org.springframework.data.annotation.Id;


public class Product {
	
	@Id
	private int pid;
	private String category;
	private String productName;
	private int price;
	
	
	public Product() {
		
	}
	
	
	public Product(int pid, String category, String productName, int price) {
		this.pid = pid;
		this.category = category;
		this.productName = productName;
		this.price = price;
	}
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
