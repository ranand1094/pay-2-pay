package com.app.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dto.UsersDTO;
import com.app.demo.dto.UsersIDDTO;
import com.app.demo.models.UsersModel;
import com.app.demo.services.UserAccountsService;
import com.app.demo.services.UserIDService;
import com.app.demo.services.UserService;

@RestController
@RequestMapping("/pay2pay/users")
public class UserController {
	
	@Autowired
	private UserService user;
	
	@Autowired
	private UserIDService userId;
	
	@Autowired
	private UserAccountsService userAccount;
	
	@RequestMapping("/")
	public UsersDTO getUsers(){
		return user.getUserDetails();
	}

	@RequestMapping("/{id}")
	public UsersDTO getSpecificUsers(@PathVariable String id) throws Exception{
		return user.getUser(id);
	}
	
	@PostMapping(value="/register")
	public UsersDTO createNewUser(@RequestBody UsersModel users){
		return user.addUser(users);
	}
	
	@PutMapping("/update/{id}")
	public UsersDTO updateUser(@RequestBody UsersModel users,@PathVariable String id) throws Exception{
		return user.updateUser(users,id);
	}
	 
	

}
