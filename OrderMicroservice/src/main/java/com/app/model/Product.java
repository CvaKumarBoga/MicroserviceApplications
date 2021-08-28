package com.app.model;

import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer prodId;
	private String prodModel;
	private String prodCode;
	@Lob 
	private byte[] prodImg;
	private Double prodCost;
	private String prodDes;
	private Integer prodQuantities;
	private String prodStatus;
}
