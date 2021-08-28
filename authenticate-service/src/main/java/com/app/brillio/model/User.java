package com.app.brillio.model;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Document(collection="user_tab")
@NoArgsConstructor
public class User {
	
	private Integer id;
	
	private String userName;
	
	private String userEmail;
	
	private String userPassword;
	
	private String role;

}
