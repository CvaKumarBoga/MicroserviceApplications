package com.app.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE",url = "http://localhost:2022/ecommerse" )
public interface ProductConsumer {
	
	@GetMapping("/product/show")
	public String show();
	@GetMapping("product/get/{code}")
	public ResponseEntity<String> getProductByCode(@PathVariable("code") String prodCode);
	@GetMapping("allprods")
	public ResponseEntity<?> getAllItems();

}
