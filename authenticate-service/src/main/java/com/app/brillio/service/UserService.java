package com.app.brillio.service;

import com.app.brillio.model.User;
import com.app.brillio.request.LoginRequest;
import com.app.brillio.response.LoginResponse;

public interface UserService {
	
	public Integer signupNewUser(User user);
	public LoginResponse userLogin(LoginRequest request);

}
