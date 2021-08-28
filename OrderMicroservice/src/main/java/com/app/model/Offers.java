package com.app.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offers {

	private Integer offId;
	private String offCode;
	private Double amount;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Temporal(value = TemporalType.DATE)
	private Date expDate;
}
