package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Offers;
import com.app.service.OffersService;

@RestController
@RequestMapping("offer")
public class OffersController {

	@Autowired
	private OffersService service;

	@PostMapping("create")
	public ResponseEntity<String> makeOffer(@RequestBody Offers offers) {
		ResponseEntity<String> resp = null;
		try {
			service.createOffer(offers);
			resp = new ResponseEntity<String>("Offer is created succesfully...",HttpStatus.CREATED);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Internal server error..",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	@GetMapping("get/{code}")
	public ResponseEntity<?> getOffer(@PathVariable("code") String offCode ) {
		ResponseEntity<?> resp = null;
		Offers offer = service.findByCode(offCode);
		try {
			if(offer!=null) {
				resp = new ResponseEntity<Offers>(offer,HttpStatus.OK);
			}else {
				resp = new ResponseEntity<String>("Invalid offer code...",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("all")
	public ResponseEntity<String> getAllOffers() {
		ResponseEntity<?> resp = null;
		try {
			List<Offers> offers = service.getAllOffers();
			if(offers!=null && !offers.isEmpty())
				resp = new ResponseEntity<List<Offers>>(offers,HttpStatus.OK);	
			else
				resp = new ResponseEntity<String>("No offers found....",HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Internal server error....",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return (ResponseEntity<String>) resp;
	}
}
