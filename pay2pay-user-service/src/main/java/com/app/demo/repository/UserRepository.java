package com.app.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.UserAccountsEntity;
import com.app.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
   
	List<UserEntity> findAll();
	UserEntity findByUserID(String userID);
	 
}
