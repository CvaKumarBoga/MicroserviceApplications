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

import com.app.consumer.OffersConsumer;
import com.app.consumer.ProductConsumer;
import com.app.model.Offers;
import com.app.model.Order;
import com.app.model.Product;
import com.app.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("order")
public class OrderRestController {

	@Autowired
	private OrderService service;

	@Autowired
	private ProductConsumer productConsumer;

	@Autowired
	private OffersConsumer offerConsumer;

	@GetMapping("get")
	public String getmsg() {
		String msg = productConsumer.show().toString();
		return msg;
	}
	@GetMapping("apply/offer/{code}")
	public ResponseEntity<?> applyOffers(@PathVariable("code") String offCode) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<?> resp = null;
		ResponseEntity<?> offer = offerConsumer.getOffer(offCode);
		ObjectMapper mapper = new ObjectMapper(); 
		Offers off = mapper.readValue(offer.getBody().toString() , Offers.class);	
		try {
			if(offer!=null)  
				resp = new ResponseEntity<Offers>(off,HttpStatus.OK);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	@SuppressWarnings({ "unchecked", "null" })
	@PostMapping("create") 
	public ResponseEntity<String> makeOrder(@RequestBody Order order) throws JsonMappingException, JsonProcessingException {
		ResponseEntity<?> res = null;
		ResponseEntity<String> entity = productConsumer.getProductByCode(order.getProduct().getProdCode());
		String obj = entity.getBody().toString();

		ResponseEntity<String> offer = offerConsumer.getOffer(order.getOffers().getOffCode());
		String offobj = offer.getBody().toString();

		ObjectMapper mapper = new ObjectMapper();
		Product p = mapper.readValue(obj, Product.class);
		Offers o = mapper.readValue(offobj, Offers.class);
		try {
			if(p!=null) {
				order.setProdCode(p.getProdCode());
				order.setDiscount(o.getAmount());
				order.setActualamount(p.getProdCost());
				order.setFinalAmount((order.getQuantity() * p.getProdCost()) - (o.getAmount()));
			}
		} catch (Exception e) {
			/*
			 * String s=(order.getProduct().getProdCode()!=p.getProdCode()) ?
			 * "Invalid Product Code!.Please try again..."
			 * :"Invalid Offer Code!.Please try again"; res=new
			 * ResponseEntity<String>(s,HttpStatus.BAD_REQUEST);
			 */
			e.printStackTrace();
		}
		service.createOrder(order);
		res = new ResponseEntity<String>("Order is created succesfully!....",HttpStatus.CREATED);
		return (ResponseEntity<String>) res;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("all")
	public ResponseEntity<String> getOrders() {
		ResponseEntity<?> resp = null;
		try {
			List<Order> orders = service.getAllOrders();
			resp = new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Internal server error..",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return (ResponseEntity<String>) resp;
	}
}
