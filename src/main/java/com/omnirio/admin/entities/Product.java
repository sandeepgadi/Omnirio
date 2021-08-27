package com.omnirio.admin.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String productId;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;

	// cascade = CascadeType.ALL,
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "product_attributes_mapping", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "attributes_id", referencedColumnName = "id", insertable = false, updatable = false) })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Attribute> attributes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

}
