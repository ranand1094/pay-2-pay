package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.UserAccountsEntity;
import com.app.entity.UserCompositeKeys;
import com.app.entity.UserEntity;

@Repository
public interface UserAccountsRepository extends JpaRepository<UserAccountsEntity,UserCompositeKeys>{

 }
