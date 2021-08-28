package com.app.brillio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.app.brillio.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	
	public User findByUserEmail(String userEmail);

}
