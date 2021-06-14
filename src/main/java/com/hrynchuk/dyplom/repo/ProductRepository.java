package com.hrynchuk.dyplom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrynchuk.dyplom.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findById(int id);
}
