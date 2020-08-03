package com.crosspay.rates.model;

import java.io.Serializable;
import java.sql.Date;

public class UpdateIBRModel implements Serializable{
	
	private String ccyCode;
	private double rate;
	private Date asOnDate;
	
	
	
	@Override
	public String toString() {
		return "UpdateIBRModel [ccyCode=" + ccyCode + ", rate=" + rate + ", asOnDate=" + asOnDate + "]";
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getAsOnDate() {
		return asOnDate;
	}
	public void setAsOnDate(Date asOnDate) {
		this.asOnDate = asOnDate;
	}
	
	

}
