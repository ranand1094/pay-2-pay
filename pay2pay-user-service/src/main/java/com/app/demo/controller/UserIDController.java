package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dto.UsersIDDTO;
import com.app.demo.dto.UsersIDListDTO;
import com.app.demo.models.UsersIDModel;
import com.app.demo.services.UserIDService;
@RestController
@RequestMapping("/pay2pay/userIds")
public class UserIDController {
	

	@Autowired
	private UserIDService userId;
	
	@GetMapping("/{userID}")
	public UsersIDListDTO getUserIDs(@PathVariable String userID)
	{
		return userId.getUserID(userID);
	}
	
	@PostMapping("/add")
	public UsersIDDTO addUserIDs(UsersIDModel userIds)
	{
		return userId.addUserIds(userIds);
	}
	

}
