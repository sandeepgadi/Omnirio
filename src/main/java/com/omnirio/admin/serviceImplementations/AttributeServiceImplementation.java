package com.omnirio.admin.serviceImplementations;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.omnirio.admin.entities.Attribute;
import com.omnirio.admin.exceptions.OmnirioException;
import com.omnirio.admin.repositories.AttributeRepository;
import com.omnirio.admin.services.AttributeService;

@Service
@Transactional
public class AttributeServiceImplementation implements AttributeService {

	@Autowired private AttributeRepository attributesRepository;
	
	@Override
	public ResponseEntity<Attribute> addAttributes(Attribute attributes) {
		attributes=attributesRepository.save(attributes);
		return new ResponseEntity<Attribute>(attributes, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Attribute> viewAttributes(Long id) {
		Optional<Attribute> attributes=attributesRepository.findById(id);
		if(attributes.isPresent()) {
			return new ResponseEntity<Attribute>(attributes.get(), HttpStatus.OK);
		}else {
			throw new OmnirioException("Attribute Not Found");
		}
	}

	@Override
	public ResponseEntity<List<Attribute>> allAttributes() {
		List<Attribute> attributes=attributesRepository.findAll();
		if(!attributes.isEmpty()) {
			return new ResponseEntity<List<Attribute>>(attributes, HttpStatus.OK);
		}else {
			throw new OmnirioException("Attribute Not Found");
		}
	}

}
