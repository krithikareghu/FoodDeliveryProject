package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.CartData;
import com.project.FoodDeliveryService.Model.OrderData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.dto.UserDataDto;

import antlr.collections.List;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
	UserData findByPhonenumber(String Phonenumber);
	UserData findByEmail(String email);
	UserData findByUsername(String username);
	boolean existsByUsername(String username);
	Object save(UserDataDto user);
	boolean existsByPhonenumber(String phonenumber);
	boolean existsByEmail(String email);
	//boolean existscartDatas(OrderData order);
	//CartData findbycartdata(CartData cartitems);
	
	
	
	
	
	//boolean existsByUsername(String username);

}