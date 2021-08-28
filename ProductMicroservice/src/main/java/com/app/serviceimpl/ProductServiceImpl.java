package com.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;
import com.app.repo.ProductRepository;
import com.app.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository repo;
	
	@Transactional
	@Override
	public Integer saveProduct(Product product) {
		Product p = repo.save(product);
		return p.getProdId();
	}

	@Transactional(readOnly = true)
	@Override
	public Product getProduct(Integer prodId) {
		Optional<Product> pid = repo.findById(prodId);
		if(pid.isPresent()) {
			return pid.get();
		}
		return null;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Product findProduct(String code) {
		Optional<Product> pcode = repo.findByProdCode(code);
		if(pcode.isPresent()) {
			return pcode.get();
		}
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	
}
