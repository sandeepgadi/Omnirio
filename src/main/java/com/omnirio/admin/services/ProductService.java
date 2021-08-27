package com.omnirio.admin.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.omnirio.admin.entities.Product;

public interface ProductService {

	ResponseEntity<Product> addProduct(Product products);

	ResponseEntity<Product> viewProduct(Long id);

	ResponseEntity<List<Product>> allProducts();

}
