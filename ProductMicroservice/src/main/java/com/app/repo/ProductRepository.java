package com.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	public Optional<Product> findByProdCode(String prodCode);
	public Optional<Product> findByProdId(String prodId);
}
