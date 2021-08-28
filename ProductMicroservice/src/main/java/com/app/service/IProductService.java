package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface IProductService {
	
	public Integer saveProduct(Product product);
	public Product getProduct(Integer prodId);
	public Product findProduct(String code);
	public List<Product> getAllProducts();

}
