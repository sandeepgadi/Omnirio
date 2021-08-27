package com.omnirio.admin.serviceImplementations;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.omnirio.admin.entities.Product;
import com.omnirio.admin.exceptions.OmnirioException;
import com.omnirio.admin.repositories.ProductRepository;
import com.omnirio.admin.services.ProductService;

@Service
@Transactional
public class ProductServiceImplementation implements ProductService {

	@Autowired private ProductRepository productRepository;
	
	@Override
	public ResponseEntity<Product> addProduct(Product products) {
		products=productRepository.save(products);
		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Product> viewProduct(Long id) {
		Optional<Product> product=productRepository.findById(id);
		if(product.isPresent()) {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		}else {
			throw new OmnirioException("Product Not Found");
		}
	}

	@Override
	public ResponseEntity<List<Product>> allProducts() {
		List<Product> product=productRepository.findAll();
		if(!product.isEmpty()) {
			return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
		}else {
			throw new OmnirioException("Product Not Found");
		}
	}

}
