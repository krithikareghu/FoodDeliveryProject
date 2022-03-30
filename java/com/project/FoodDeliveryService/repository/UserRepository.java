package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
	UserData findByEmail(String email);
	boolean existsByEmail(String email);

}