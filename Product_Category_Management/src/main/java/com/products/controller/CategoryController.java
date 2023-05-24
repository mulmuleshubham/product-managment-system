package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.request.CategoryRequest;
import com.products.entity.Category;
import com.products.serviceImpl.CategoryServiceImpl;

@RestController
@RequestMapping("categories")
public class CategoryController {
	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	
	@PostMapping("/add")
	ResponseEntity<String > addCategory(@RequestBody CategoryRequest categoryRequest){
		categoryServiceImpl.addEditCategory(null,categoryRequest);
		return ResponseEntity.ok("success");
		}
		@PutMapping("/edit/{categoryId}")
	ResponseEntity<String> editCategory(@PathVariable String categoryId,  @RequestBody CategoryRequest categoryRequest){
		categoryServiceImpl.addEditCategory(categoryId, categoryRequest);
		return ResponseEntity.ok("edit success");
	}
	
	@GetMapping("/find/{categoryId}")
	ResponseEntity<Object> getByid(@PathVariable String categoryId){
		Category catgoryById = categoryServiceImpl.getCatgoryById(categoryId);
		return ResponseEntity.ok(catgoryById);
	}
	
	@GetMapping("/list")
	ResponseEntity<?> categoryList(){
		List<Category> categories = categoryServiceImpl.getCategories();
		return ResponseEntity.ok(categories);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<?> deleteCategory(String categoryId){
		String response = categoryServiceImpl.deleteById(categoryId);
		return ResponseEntity.ok(response);
	
	
	}
}
