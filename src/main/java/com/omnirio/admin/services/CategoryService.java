package com.omnirio.admin.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.omnirio.admin.entities.Category;

public interface CategoryService {

	ResponseEntity<Category> addCategory(Category category);

	ResponseEntity<Category> viewCategory(Long id);

	ResponseEntity<List<Category>> allCategory();

}
