package com.hrynchuk.dyplom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrynchuk.dyplom.entity.Product;
import com.hrynchuk.dyplom.repo.ProductRepository;

@Component
public class ProductDAO {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> getAll() {
		List<Product> list = repo.findAll();
		
		return list;
	}
	
	public Product findById(int id) {
		return repo.findById(id);
	}
	
	public void save(Product product) {
		repo.save(product);
	}
}
