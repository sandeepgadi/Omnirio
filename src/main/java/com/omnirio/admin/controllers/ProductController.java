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

import com.omnirio.admin.entities.Product;
import com.omnirio.admin.services.ProductService;

@RestController
@RequestMapping("api")
public class ProductController {
	
	@Autowired private ProductService productService;

	@PostMapping("v1/add/product")
    ResponseEntity<Product> addProduct(@RequestBody Product products) {
        return productService.addProduct(products);
    }
	
	@GetMapping("v1/view/product/{id}")
    ResponseEntity<Product> viewProduct(@PathVariable Long id) {
        return productService.viewProduct(id);
    }
	
	@GetMapping("v1/all/products")
    ResponseEntity<List<Product>> allProducts() {
        return productService.allProducts();
    }
}
