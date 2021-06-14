package com.hrynchuk.dyplom.entity;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
	private String name;
	private double price;
	private String description;
	private MultipartFile fileData;
	
	public ProductForm() { }
	
	public ProductForm(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}
	
	
}
