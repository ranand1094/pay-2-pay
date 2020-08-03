package com.app.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dto.UsersIDDTO;
import com.app.demo.dto.UsersIDListDTO;
import com.app.demo.models.UsersIDModel;
import com.app.demo.repository.UserIdsRepository;
import com.app.demo.services.helper.ServiceHelper;
import com.app.entity.UserCompositeKeys;
import com.app.entity.UserIDs;

@Service
public class UserIDService {
	
	@Autowired
	private UserIdsRepository usersIdRepo;

	@Autowired
	private ServiceHelper helper;
	
	private UserIDs userIdsEntities = new UserIDs();
	private UsersIDDTO userIDDTO = new UsersIDDTO();
	private UsersIDListDTO userIDListDTO = new UsersIDListDTO();

	private UsersIDModel userIDModel = new UsersIDModel();
	private List<UserIDs> userIdsEntitiesList = new ArrayList<UserIDs>();
	
	public UsersIDListDTO getUserID(String userID) {
		// TODO Auto-generated method stub
		
		Optional<List<UserIDs>> optionalUserIDEntites = usersIdRepo.findByPrimaryUserID(userID);
		
		if(optionalUserIDEntites.isPresent())
		{
			userIdsEntitiesList = optionalUserIDEntites.get();
			//List<UsersIDModel> userIdsListModel = helper.convert2List(userIdsEntities, userIDModel, userIdsEntitiesList);
			userIDListDTO.setUserIDList(userIdsEntitiesList);
			userIDListDTO.setReturnCode("2001");
			userIDListDTO.setReturnMsg("Request processed successfully");
		}
		else
		{
			userIDListDTO.setReturnCode("4000");
			userIDListDTO.setReturnMsg("No Details available");
		}
		
		return userIDListDTO;
	}

	public UsersIDDTO addUserIds(UsersIDModel userIds) {
		
		boolean optionalUserIDEntites = usersIdRepo.existsByidType(userIds.getIdType());
		if(optionalUserIDEntites)
		{
				userIDDTO.setReturnCode("4010");
				userIDDTO.setReturnMsg("ID Type Already exists");
			
		}
		else
		{
			userIdsEntities = helper.convert(userIds, userIdsEntities);
			usersIdRepo.save(userIdsEntities);
			userIDDTO = helper.convert(userIdsEntities, userIDDTO);
			userIDDTO.setReturnCode("2001");
			userIDDTO.setReturnMsg("Request processed successfully");
		}
		
		return userIDDTO;
	}
	
}

