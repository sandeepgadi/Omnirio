package com.omnirio.admin.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.admin.entities.Category;
import com.omnirio.admin.services.CategoryService;

@RestController
@RequestMapping("api")
public class CategoryController {
	
	@Autowired CategoryService categoryService;

	@PostMapping("v1/add/category")
    ResponseEntity<Category> addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
	
	@GetMapping("v1/view/category/{id}")
    ResponseEntity<Category> viewCategory(@PathVariable Long id) {
        return categoryService.viewCategory(id);
    }
	
	@GetMapping("v1/all/category")
    ResponseEntity<List<Category>> allCategory() {
        return categoryService.allCategory();
    }
}
