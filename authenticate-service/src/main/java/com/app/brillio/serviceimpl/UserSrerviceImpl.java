package com.app.brillio.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.brillio.model.User;
import com.app.brillio.repository.UserRepository;
import com.app.brillio.request.LoginRequest;
import com.app.brillio.response.LoginResponse;
import com.app.brillio.service.UserService;

@Service
public class UserSrerviceImpl implements UserService{

	@Autowired
	private UserRepository repo;

	@Transactional
	@Override
	public Integer signupNewUser(User user) {
		return repo.save(user).getId() ;
	}

	@Transactional
	@Override
	public LoginResponse userLogin(LoginRequest request) {
		User user = repo.findByUserEmail(request.getUserName());

		if (user.getUserEmail().equals(request.getUserName()) &&
				user.getUserPassword().equals(request.getPassword())) { LoginResponse
			loginResponse = new LoginResponse(); loginResponse.setMessage("Success");
			loginResponse.setStatus(HttpStatus.OK);
			loginResponse.setRole(user.getRole()); 
			return loginResponse; 
		}else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("Invalid user name or Password.");
			loginResponse.setStatus(HttpStatus.BAD_REQUEST);
			loginResponse.setRole(user.getRole()); 
			return loginResponse; 
		}
	}
}


