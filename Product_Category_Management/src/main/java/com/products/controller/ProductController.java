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

import com.product.request.ProductRequest;
import com.products.entity.Product;
import com.products.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@PostMapping("add")
	public ResponseEntity<String> addProduct (@RequestBody  ProductRequest productRequest){
		System.err.println("ssasssss"+productRequest.getCategoryId());
		String responce = productServiceImpl.addEditProdduct(null, productRequest);
		return ResponseEntity.ok(responce);
	}
	
	@PutMapping("/edit/product/{productId}")
	public ResponseEntity<String> eddiProduct(@PathVariable String productid, @RequestBody ProductRequest productRequest) {
		String responce = productServiceImpl.addEditProdduct(productid, productRequest);
		return ResponseEntity.ok(responce);
	}
	
	@GetMapping("find/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable String productId){
		Product response = productServiceImpl.getById(productId);
		return ResponseEntity.ok(response);	
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> findAll(){
		List<Product> productList = productServiceImpl.getProductList();
		return ResponseEntity.ok(productList);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<?> deleteProduct(String productId){
		String response = productServiceImpl.deleteByid(productId);
		return ResponseEntity.ok(response);
	}
	
	

}
