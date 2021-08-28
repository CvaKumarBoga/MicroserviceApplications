package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
