package com.crosspay.rates.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="InterBankRates")

public class InterBankRates implements Serializable {
	
	@Id
	@Column(length = 3)
	private String ccyCode;
	private double rate;
	private Date asOnDate;
	
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
