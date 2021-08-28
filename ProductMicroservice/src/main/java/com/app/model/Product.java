package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product_Tab")
public class Product {

	@Id
	@GeneratedValue
	private Integer prodId;
	private String prodCode;
	@Lob 
	private byte[] prodImg;
	private Double prodCost;
	private String prodDes;
	private Integer prodQuantities;
	private String prodStatus;

}
