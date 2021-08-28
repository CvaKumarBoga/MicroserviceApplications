package com.app.brillio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.brillio.model.User;
import com.app.brillio.repository.UserRepository;
import com.app.brillio.request.LoginRequest;
import com.app.brillio.response.LoginResponse;
import com.app.brillio.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin("http://localhost:3000")
public class AuthenticateController {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private UserService service;

	//user sign up api

	@PostMapping("signup")
	public ResponseEntity<String> registrerUser(@RequestBody User user) {
		ResponseEntity<String> resp = null;
		try {
			Integer id = service.signupNewUser(user);
			if(id != 0) {
				resp = new ResponseEntity<String>("Succesfully singup..", HttpStatus.OK);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to signup..",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	//user Login
	
	@PostMapping("login")
	public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
		LoginResponse userLogin = service.userLogin(loginRequest);
		return userLogin;
	}
	
	/*
	 * @GetMapping("get/{email}") public User get(@PathVariable String email) {
	 * return repo.findByUserEmail(email); }
	 */

}

