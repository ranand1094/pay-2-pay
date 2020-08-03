package com.crosspay.rates.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

public class RatesModel implements Serializable {
	
	@NotNull
	@Max(value = 3, message = "From Ccy should be atleat 3 characters")
	@Min(value = 3, message = "From Ccy should be atleat 3 characters")
 	private String fromCcy;

	@NotNull()
 	@Max(value = 3, message ="")
	@Min(value = 3, message = "To Ccy should be atleat 3 characters")
	private String toCcy;

	@NotNull
	@DecimalMax(value = "4")
	@Pattern(regexp = "^-?\\d*\\.\\d+$" ,message = "Invaild Amount")
	private Double amount;
	
	
	public String getFromCcy() {
		return fromCcy;
	}
	public void setFromCcy(String fromCcy) {
		this.fromCcy = fromCcy;
	}
	public String getToCcy() {
		return toCcy;
	}
	public void setToCcy(String toCcy) {
		this.toCcy = toCcy;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
