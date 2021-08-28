package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer_Details")
public class Customer {
	@Id
	@GeneratedValue
	private Integer customerId;
	private String name;
	private Long mobileNo;
	private String email;
	private String shippingAddr;
	
}
