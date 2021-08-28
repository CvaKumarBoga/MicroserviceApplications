package com.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Offers_Tab")
public class Offers {

	@Id
	@GeneratedValue
	private Integer offId;
	private String offCode;
	private Double amount;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Temporal(value = TemporalType.DATE)
	private Date expDate;
}
