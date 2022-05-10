package com.project.FoodDeliveryService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.dto.Roletouserdto;
import com.project.FoodDeliveryService.repository.CategoryRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;
import com.project.FoodDeliveryService.repository.RestaurantRepository;
import com.project.FoodDeliveryService.repository.RoleRepository;
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
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	
	@GetMapping("/forAdmin")
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This is for Admin";
	}
	@GetMapping("/forUser")
	@PreAuthorize("hasRole('user')")
	public String forUser() {
		return "this is for user";
	}
	@GetMapping("/allusers")
	@PreAuthorize("hasRole('Admin')")
	public java.util.List<UserData> getallusers() {
		return userrepo.findAll();
	}

	@GetMapping("/allitems")
	@PreAuthorize("hasRole('Admin')")
	public java.util.List<ItemsData> getallitems() {
		return itemrepo.findAll();
	}

	@GetMapping("/allrestaurantdetails")
	@PreAuthorize("hasRole('Admin')")
	public java.util.List<RestaurantData> getallrestaurantdetails() {
		return restaurantrepo.findAll();
	}
	
	@GetMapping("/allrestaurants")
	@PreAuthorize("hasRole('Admin')")
	public List<String> getallrestaurants() {
		List<String> restaurants=new ArrayList<String>();
		for(RestaurantData restaurantData:restaurantrepo.findAll())
		{
			restaurants.add(restaurantData.getRestaurantname());
		}
		return restaurants;
	 
	}

	@PostMapping ("/saverole")
	public Roledata saverole(@RequestBody Roledata role)
	{
		return roleRepository.save(role);
		
	}
	

		
	
}
