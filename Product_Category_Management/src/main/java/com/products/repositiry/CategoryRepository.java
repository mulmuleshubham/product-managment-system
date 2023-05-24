package com.products.repositiry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Optional<Category>findByid(Long categoryId);
	List<Category> findAll();
}
