package com.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Offers;
import com.app.repo.OffersRepository;
import com.app.service.OffersService;

@Service
public class OffersServiceImpl implements OffersService{

	@Autowired
	private OffersRepository repo;

	@Transactional
	@Override
	public Integer createOffer(Offers offers) {
		return repo.save(offers).getOffId();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Offers> getAllOffers() {
		return repo.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Offers findByCode(String code) {
		Optional<Offers> offer = repo.findByOffCode(code);
		if(offer.isPresent()) {
			return offer.get();
		}
		return null;
	}
}
