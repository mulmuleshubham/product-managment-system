package com.products.repositiry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findById(Long productId);
	List<Product> findAll();
}
