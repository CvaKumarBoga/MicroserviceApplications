package com.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order_Table")
public class Order {
	
	@Id
	@GeneratedValue
	private Integer OrderId;
	private Integer customerId;
	private String prodCode;
	@Temporal(value = TemporalType.DATE)
	private Date orderDate;
	private Double actualamount;
	private Double discount;
	private Integer quantity;
	private Double finalAmount;
	private String status;
	
	@Autowired
	@Transient
	//The Jackson @JsonIgnore annotation can be used to ignore a certain property or field of a Java object.
	//@JsonIgnore
	private Product product;
	
	@Autowired
	@Transient
	private Offers offers;

}
