package com.project.FoodDeliveryService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.Categorydto;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;

@Repository
public interface CategoryRepository extends JpaRepository<Categorydata, Long> {

	

	boolean existsBycategoryname(String categoryname);

	Categorydata findAllByID(Long categoryid);

	Categorydata findBycategoryname(String categoryname);

	Categorydata findByID(Long categoryid);

	
	//Optional<Categorydata> findAllByID1(Long id);

	



}
