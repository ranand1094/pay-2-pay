package com.app.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
	
	@Id
	@Column(length = 12)
	private String userID;
	private String firstName;
	private String lastName;
	private String emailID;
	private String phoneNumber;
	private String password;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String zip;
	private int status;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserCompositeKeys.userID",referencedColumnName = "userID")
	private List<UserIDs> userIds;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserCompositeKeys.userID",referencedColumnName = "userID")
	private List<UserAccountsEntity> userAccounts; 
	

	public List<UserIDs> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<UserIDs> userIds) {
		this.userIds = userIds;
	}
	public List<UserAccountsEntity> getUserAccounts() {
		return userAccounts;
	}
	public void setUserAccounts(List<UserAccountsEntity> userAccounts) {
		this.userAccounts = userAccounts;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
