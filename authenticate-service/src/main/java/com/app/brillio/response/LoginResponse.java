package com.app.brillio.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class LoginResponse {
	
	public String message;
	public HttpStatus status;
	public String role;
	
}
