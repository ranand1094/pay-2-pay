package com.app.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.UserCompositeKeys;
import com.app.entity.UserIDs;

@Repository
public interface UserIdsRepository extends JpaRepository<UserIDs,UserCompositeKeys> {

	Optional<List<UserIDs>> findByPrimaryUserID(String userID);
	//Optional<UserIDs> findByUserIDAndidTypeAndidNumber(String userID,int idType,String idNumber);
	
	boolean existsByidType(String idType);
 }
