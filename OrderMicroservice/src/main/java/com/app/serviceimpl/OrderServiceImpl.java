package com.app.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Order;
import com.app.repo.OrderRepository;
import com.app.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;
	
	@Transactional
	@Override
	public Integer createOrder(Order order) {
		order.setStatus("NEW");
		order.setOrderDate(new Date());
		return repo.save(order).getOrderId();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Order> getAllOrders() {
		return repo.findAll();
	}
	
}
