package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.Roledata;

@Repository
public interface RoleRepository extends CrudRepository<Roledata, String> {

	Roledata findByrolename(String rolename);
//
//	Role findbyrolename(String rolename);
//
}
