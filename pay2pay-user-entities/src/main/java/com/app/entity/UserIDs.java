package com.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "user_ids")
public class UserIDs implements Serializable {
	
	@EmbeddedId
	private UserCompositeKeys primary;
	private String idType;
	private String idNumber;
	private String idIssuedBy;
	private String idIssuedAt;
	private Date idIssuedDate;
	private Date idExpiryDate;
	private int idStatus;
	
	@ManyToOne
	private UserEntity userEntity;
	
	
 
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public UserCompositeKeys getPrimary() {
		return primary;
	}
	public void setPrimary(UserCompositeKeys primary) {
		this.primary = primary;
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

@Embeddable
class UserIdPrimary implements Serializable{
	@Column(length = 12)
 	private String userID;
	private int serialNumber;
	 
	 
	public String getUserId() {
		System.out.println("Getter us + "+userID);

		return userID;
	}
	public void setUserId(String userID) {
		this.userID = userID;
	}
	public int getSerialNumber() {
		System.out.println("Getter ser + "+serialNumber);
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

}
