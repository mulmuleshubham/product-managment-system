package com.products.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.IdNotFoundException;
import com.product.request.CategoryRequest;
import com.products.entity.Category;
import com.products.repositiry.CategoryRepository;
import com.products.service.categoryService;


@Service
public class CategoryServiceImpl implements categoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Transactional
	public String addEditCategory (String categoryId, CategoryRequest categoryRequest) {
		Category category =null;
		if(Objects.nonNull(categoryId)) {
			category =getCatgoryById(categoryId);
		}else {
			category = new Category();
		}
		category.setName(categoryRequest.getName());
		categoryRepository.save(category);
		return category.toString();
	}

	
	public Category getCatgoryById(String categoryId){
		Category category = null;
		if(Objects.nonNull(categoryId)) {
			Optional<Category> categorys = categoryRepository.findByid(Long.valueOf(categoryId));
			System.err.println(categorys);
			if(categorys.isEmpty()) {
				throw new IdNotFoundException("category id not found");
		 	}
			category = categorys.get();
		}
		return category;
	}
	
	public List<Category> getCategories(){
		 List<Category> categories = categoryRepository.findAll();
		 return categories;
	}
	
	public String deleteById(String categoryId) {
		if(Objects.nonNull(categoryId)) {
			Category category = getCatgoryById(categoryId);
			categoryRepository.delete(category);
		}
		return "Delete suceess";
	}
}
