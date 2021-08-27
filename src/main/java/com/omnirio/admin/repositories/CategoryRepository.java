package com.omnirio.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnirio.admin.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
