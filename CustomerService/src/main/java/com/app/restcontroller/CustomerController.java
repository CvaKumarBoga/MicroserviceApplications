package com.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveDetails(@RequestBody Customer customer) {
		ResponseEntity<String> resp=null;
		try {
			service.saveData(customer);
			resp=new ResponseEntity<String>("User details added succesfully!..",HttpStatus.OK);
		}
		catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

}
