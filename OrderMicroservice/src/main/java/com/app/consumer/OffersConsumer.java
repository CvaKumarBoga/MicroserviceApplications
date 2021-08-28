package com.app.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.model.Offers;

@FeignClient(name = "OFFERS-SERVICE",url= "http://localhost:2025/ecommerse")
public interface OffersConsumer {

	@PostMapping("offers/create")
	public ResponseEntity<String> makeOffer(@RequestBody Offers offers);
	@GetMapping("offer/get/{code}")
	public ResponseEntity<String> getOffer(@PathVariable("code") String offCode );
	@GetMapping("offers/all")
	public ResponseEntity<String> getAllOffers();
}
