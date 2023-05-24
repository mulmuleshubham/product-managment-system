package com.product.request;

public class ProductRequest {
	
	private String categoryId;
	private String name;
	private String price;
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public ProductRequest(String categoryId, String name, String price) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
