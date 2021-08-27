package com.omnirio.admin.serviceImplementations;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.omnirio.admin.entities.Category;
import com.omnirio.admin.exceptions.OmnirioException;
import com.omnirio.admin.repositories.CategoryRepository;
import com.omnirio.admin.services.CategoryService;

@Service
@Transactional
public class CategoryServiceImplementation implements CategoryService {
	
	@Autowired private CategoryRepository categoryRepository;

	@Override
	public ResponseEntity<Category> addCategory(Category category) {
		category=categoryRepository.save(category);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Category> viewCategory(Long id) {
		Optional<Category> category=categoryRepository.findById(id);
		if(category.isPresent()) {
			return new ResponseEntity<Category>(category.get(), HttpStatus.OK);
		}else {
			throw new OmnirioException("Category Not Found");
		}
		
	}
	
	@Override
	public ResponseEntity<List<Category>> allCategory() {
		List<Category> category=categoryRepository.findAll();
		if(!category.isEmpty()) {
			return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
		}else {
			throw new OmnirioException("Category Not Found");
		}
		
	}

}
