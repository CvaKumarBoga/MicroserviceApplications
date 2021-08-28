package com.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Offers;

public interface OffersRepository extends JpaRepository<Offers, Integer>{

	public Optional<Offers> findByOffCode(String code);
}
