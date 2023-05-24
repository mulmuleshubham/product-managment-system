package com.products.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.IdNotFoundException;
import com.product.request.ProductRequest;
import com.products.entity.Category;
import com.products.entity.Product;
import com.products.repositiry.ProductRepository;
import com.products.response.ProductDetailsResponse;
import com.products.service.productService;


@Service
public class ProductServiceImpl implements productService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	
	public String addEditProdduct(String productId, ProductRequest productRequest) {
		Product product = null;
		if(Objects.nonNull(productId)){
			product = getById(productId);
		}else {
			product = new  Product();
		}
		product.setName(productRequest.getName());
		product.setPrice(Double.valueOf(productRequest.getPrice()));
		Category category = categoryServiceImpl.getCatgoryById(productRequest.getCategoryId());
		product.setCategory(category);
		productRepository.save(product);
		return "save success";
	}
	 public Product getById(String productId) {
		 Product products = null;
		 if (Objects.nonNull(productId)) {
			 Optional<Product> product = productRepository.findById(Long.valueOf(productId));
		
			 if(product.isEmpty()) {
				throw new IdNotFoundException("product id not found");
			 }
			 products = product.get();
		 }
		return products; 
	 }
	 
	 
	 public List<ProductDetailsResponse> getProductList() {
		 List<Product> products = productRepository.findAll();
		 List<ProductDetailsResponse> productDetailsResponses = new ArrayList<>();
		 for (Product product : products) {
			 ProductDetailsResponse  detailsResponse = new ProductDetailsResponse();
			 detailsResponse.setCategory_Name(product.getCategory().getName());
			 int dd = (int) product.getId();
			 detailsResponse.setProduct_id(dd);
			 detailsResponse.setProduct_price(product.getPrice());
			 detailsResponse.setProduct_name(product.getName());
			 productDetailsResponses.add(detailsResponse);
		}
		 return productDetailsResponses;
		 
	 }
	 
	 public String deleteByid(String productId) {
		if(Objects.nonNull(productId)) {
			Product product = getById(productId);
			productRepository.delete(product);
		}
		 return "delete Success";
	 }

}
