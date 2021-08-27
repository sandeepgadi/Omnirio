package com.omnirio.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnirio.admin.entities.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

}
