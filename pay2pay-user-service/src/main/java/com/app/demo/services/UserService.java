package com.app.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dto.UsersDTO;
import com.app.demo.models.UsersModel;
import com.app.demo.repository.UserRepository;
import com.app.demo.services.helper.ServiceHelper;
import com.app.entity.UserEntity;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ServiceHelper serviceHelper;

	private UserEntity userEntity = new UserEntity();
	private UsersDTO userDTO = new UsersDTO();
	private List<UserEntity> userEntityList = new ArrayList<>();

	public UsersDTO getUserDetails() {
		userEntityList = new ArrayList<>();
		userRepo.findAll().forEach(userEntityList::add);

		if (userEntityList.isEmpty()) {
			userDTO.setReturnCode("201");
			userDTO.setReturnMsg("No Users Found.");
		} else {
			userDTO = serviceHelper.convert(userEntity, userDTO);

			userDTO.setReturnCode("200");
			userDTO.setReturnMsg("Success");
		}
		return userDTO;
	}

	public UsersDTO getUser(String id) throws Exception {

		Optional<UserEntity> userSearch = userRepo.findById(id);
		if (userSearch.isPresent()) {

			UserEntity e = userSearch.get();
			userDTO = serviceHelper.convert(userSearch.get(), userDTO);
			userDTO.setReturnCode("20001");
			userDTO.setReturnMsg("Success");
		} else {
			userDTO = serviceHelper.convert(userSearch.get(), userDTO);
			userDTO.setReturnCode("2001");
			userDTO.setReturnMsg("User Not found");
		}
		return userDTO;
	}

	public UsersDTO addUser(UsersModel users) {
		userEntity = serviceHelper.convert(users, userEntity);

		if (!userRepo.existsById(userEntity.getUserID())) {
			userRepo.save(userEntity);

			userDTO = serviceHelper.convert(userEntity, userDTO);
			userDTO.setReturnCode("4000");
			userDTO.setReturnMsg("Success");
		} else {
			userDTO = serviceHelper.convert(userEntity, userDTO);

			userDTO.setReturnCode("3000");
			userDTO.setReturnMsg("User Already exists");
		}

		return userDTO;
	}

	public UsersDTO updateUser(UsersModel users, String id) {

		if (!userRepo.existsById(userEntity.getUserID())) {
			userDTO = serviceHelper.convert(userEntity, userDTO);

			userDTO.setReturnCode("404");
			userDTO.setReturnMsg("User Not Found");
		} else {
			userEntity = serviceHelper.convert(users, userEntity);
			userRepo.save(userEntity);
			userDTO.setReturnCode("4000");
			userDTO.setReturnMsg("Update Success");
			userDTO = serviceHelper.convert(userEntity, userDTO);
		}

		return userDTO;
	}

}
