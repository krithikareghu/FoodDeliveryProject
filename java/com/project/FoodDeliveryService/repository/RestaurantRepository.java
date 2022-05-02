package com.project.FoodDeliveryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodDeliveryService.Model.RestaurantData;

@Repository
public interface RestaurantRepository  extends JpaRepository<RestaurantData, Long> {

	RestaurantData findByRestaurantname(String restaurantname);

	boolean existsByrestaurantname(String restaurantname);

	RestaurantData findAllByID(Long itemid);

	//RestaurantData findByID(Long restaurantid);

	//RestaurantData findOne(Long itemid);

	

}
