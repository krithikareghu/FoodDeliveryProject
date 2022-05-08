package com.project.FoodDeliveryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.repository.CategoryRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;
import com.project.FoodDeliveryService.repository.RestaurantRepository;
import com.project.FoodDeliveryService.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminController {


	@Autowired
	ItemsRepository itemrepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	RestaurantRepository restaurantrepo;

	@GetMapping("/allusers")
	public java.util.List<UserData> getallusers() {
		return userrepo.findAll();
	}

	@GetMapping("/allitems")
	public java.util.List<ItemsData> getallitems() {
		return itemrepo.findAll();
	}

	@GetMapping("/allrestaurants")
	public java.util.List<RestaurantData> getallrestaurants() {
		return restaurantrepo.findAll();
	}

}
