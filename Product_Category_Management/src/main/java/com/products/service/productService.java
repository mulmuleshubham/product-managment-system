package com.products.service;

import java.util.List;

import com.product.request.ProductRequest;
import com.products.entity.Product;
import com.products.response.ProductDetailsResponse;

public interface productService {

	public String addEditProdduct(String productId, ProductRequest productRequest);
	
	public Product getById(String productId);
	
	public List<ProductDetailsResponse> getProductList();
	
	public String deleteByid(String productId);
}
