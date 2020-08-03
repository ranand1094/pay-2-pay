package com.app.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.repository.UserAccountsRepository;

@Service
public class UserAccountsService {

	@Autowired
	private UserAccountsRepository userAccRepo;
}
