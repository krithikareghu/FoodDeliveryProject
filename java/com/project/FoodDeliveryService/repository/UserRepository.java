package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.dto.UserDataDto;

import antlr.collections.List;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {
	UserData findByPhonenumber(String Phonenumber);
	//UserData findByID(Long id);
	UserData findByEmail(String email);
	UserData findByUsername(String username);
	boolean existsByUsername(String username);
	Object save(UserDataDto user);
	//UserData findOne(String username);
	boolean existsByPhonenumber(String phonenumber);
	boolean existsByEmail(String email);
	
	
	
	
	
	//boolean existsByUsername(String username);

}