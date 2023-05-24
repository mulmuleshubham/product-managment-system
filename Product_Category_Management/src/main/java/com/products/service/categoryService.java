package com.products.service;

import java.util.List;
import com.product.request.CategoryRequest;
import com.products.entity.Category;

public interface categoryService{

	public String addEditCategory (String categoryId, CategoryRequest categoryRequest);
	
	public Category getCatgoryById(String categoryId);
	
	public List<Category> getCategories();
	
	public String deleteById(String categoryId);
	
}
