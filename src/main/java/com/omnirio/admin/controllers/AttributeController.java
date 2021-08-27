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

import com.omnirio.admin.entities.Attribute;
import com.omnirio.admin.services.AttributeService;

@RestController
@RequestMapping("api")
public class AttributeController {

	@Autowired private AttributeService attributesService;
	
	@PostMapping("v1/add/attribute")
    ResponseEntity<Attribute> addAttributes(@RequestBody Attribute attributes) {
        return attributesService.addAttributes(attributes);
    }
	
	@GetMapping("v1/view/attribute/{id}")
    ResponseEntity<Attribute> viewAttributes(@PathVariable Long id) {
        return attributesService.viewAttributes(id);
    }
	
	@GetMapping("v1/add/attribute")
    ResponseEntity<List<Attribute>> allAttributes() {
        return attributesService.allAttributes();
    }
}
