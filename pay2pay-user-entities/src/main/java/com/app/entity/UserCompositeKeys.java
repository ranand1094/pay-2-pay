package com.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
 
public class UserCompositeKeys implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length = 12)
	private String userID;
	
	private int serialNumber;
	
 	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
 }
