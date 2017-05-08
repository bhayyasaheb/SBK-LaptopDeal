package com.sbk.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	// private properties
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Please Enter the Product Name!")
	private String name;
	
	private String code;
	
	@NotBlank(message="Please Enter the Brand Name!")
	private String brand;
	
	@JsonIgnore
	@NotBlank(message="Please Enter the Description for Product!")
	private String description;
	
	@Column(name="unit_price")
	@Min(value=1, message="The Price can not be less than 1!")
	private double unitPrice;
	
	private int quantity;
	
	@Column(name="is_active")
	@JsonIgnore
	private boolean active;
	
	@Column(name="category_id")
	@JsonIgnore
	private int categoryId;
	
	@Column(name="supplier_id")
	@JsonIgnore
	private int supplierId;
	
	private int purchases;
	
	private int views;
	
	// default constructor
	public Product(){
		this.code = "SBK" +UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	
	// setter and getter methods


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	// toString for debugging

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + "]";
	}
		
	
}
