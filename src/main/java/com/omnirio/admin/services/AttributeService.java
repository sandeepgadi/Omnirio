package com.omnirio.admin.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.omnirio.admin.entities.Attribute;

public interface AttributeService {

	ResponseEntity<Attribute> addAttributes(Attribute attributes);

	ResponseEntity<Attribute> viewAttributes(Long id);

	ResponseEntity<List<Attribute>> allAttributes();

}
