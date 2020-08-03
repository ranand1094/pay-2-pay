package com.app.demo.dto;

import java.util.Date;

public class UsersIDDTO {
	
	private String returnCode;
	private String returnMsg;
	private String userID;
	private int idSerialNumber;
	private String idType;
	private String idNumber;
	private String idIssuedBy;
	private String idIssuedAt;
	private Date idIssuedDate;
	private Date idExpiryDate;
	private int idStatus;

	
	
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public int getIdSerialNumber() {
		return idSerialNumber;
	}
	public void setIdSerialNumber(int idSerialNumber) {
		this.idSerialNumber = idSerialNumber;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdIssuedBy() {
		return idIssuedBy;
	}
	public void setIdIssuedBy(String idIssuedBy) {
		this.idIssuedBy = idIssuedBy;
	}
	public String getIdIssuedAt() {
		return idIssuedAt;
	}
	public void setIdIssuedAt(String idIssuedAt) {
		this.idIssuedAt = idIssuedAt;
	}
	public Date getIdIssuedDate() {
		return idIssuedDate;
	}
	public void setIdIssuedDate(Date idIssuedDate) {
		this.idIssuedDate = idIssuedDate;
	}
	public Date getIdExpiryDate() {
		return idExpiryDate;
	}
	public void setIdExpiryDate(Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}
	
}
