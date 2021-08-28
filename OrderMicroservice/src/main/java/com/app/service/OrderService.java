package com.app.service;

import java.util.List;

import com.app.model.Order;

public interface OrderService {
	
	public Integer createOrder(Order order);
	public List<Order> getAllOrders();

}
