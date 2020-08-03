package com.app.demo.dto;

import java.util.List;

import com.app.demo.models.UsersIDModel;
import com.app.entity.UserIDs;

public class UsersIDListDTO {

	private String returnCode;
	private String returnMsg;
	private List<UserIDs> userIDList;

	public List<UserIDs> getUserIDList() {
		return userIDList;
	}
	public void setUserIDList(List<UserIDs> userIdsEntitiesList) {
		this.userIDList = userIdsEntitiesList;
	}
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
	
	
}
