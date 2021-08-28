package com.app.service;

import java.util.List;

import com.app.model.Offers;

public interface OffersService {
	
	public Integer createOffer(Offers offers);
	public List<Offers> getAllOffers();
	public Offers findByCode(String code);

}
