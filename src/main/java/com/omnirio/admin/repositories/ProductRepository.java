package com.omnirio.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnirio.admin.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
