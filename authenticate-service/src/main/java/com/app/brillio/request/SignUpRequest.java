package com.app.brillio.request;

import lombok.Data;

@Data
public class SignUpRequest {
	
	private Integer id;
	private String userName;
	private String email;
	private String password;
	private String role;

}
