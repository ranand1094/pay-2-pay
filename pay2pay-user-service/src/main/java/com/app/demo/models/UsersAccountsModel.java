package com.app.demo.models;

import javax.persistence.Column;

public class UsersAccountsModel {
	
	private String userID;
	private int accountSerialNumber;
	private int bankID;
 	private String accountNo;
	private String bankName;
	private String ifsCode;
	private int isDefault;
	private int status;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getAccountSerialNumber() {
		return accountSerialNumber;
	}
	public void setAccountSerialNumber(int accountSerialNumber) {
		this.accountSerialNumber = accountSerialNumber;
	}
	public int getBankID() {
		return bankID;
	}
	public void setBankID(int bankID) {
		this.bankID = bankID;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfsCode() {
		return ifsCode;
	}
	public void setIfsCode(String ifsCode) {
		this.ifsCode = ifsCode;
	}
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
