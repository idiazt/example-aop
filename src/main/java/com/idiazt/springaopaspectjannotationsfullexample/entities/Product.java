package com.idiazt.springaopaspectjannotationsfullexample.entities;

public class Product extends BaseEntity {
	private String code;
	private String description;
	
	public Product(Long id, String code, String description) {
		super();
		setId(id);
		this.code = code;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description
				+ ", getId()=" + getId() + "]";
	}	
}
