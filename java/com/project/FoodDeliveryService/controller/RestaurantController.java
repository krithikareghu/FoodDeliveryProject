package com.project.FoodDeliveryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.RestaurantDataDto;
import com.project.FoodDeliveryService.Service.ItemsDetailsService;
import com.project.FoodDeliveryService.Service.RestaurantDetailService;
import com.project.FoodDeliveryService.repository.ItemsRepository;
import com.project.FoodDeliveryService.repository.RestaurantRepository;

import net.bytebuddy.asm.Advice.This;

@RestController
@CrossOrigin("http://localhost:4200")
public class RestaurantController {
	
	@Autowired
	RestaurantDetailService  restaurantDetailService;
	
	@Autowired
	ItemsDetailsService itemdetails;
	@Autowired
	ItemsRepository  itemrepo;
	@Autowired
	RestaurantRepository restaurantrepo;
	
	
	@RequestMapping(value = "/addrestaurant", method = RequestMethod.POST)
	public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantDataDto restaurant) throws Exception {
	
		if (this.restaurantrepo.existsByrestaurantname(restaurant.getRestaurantname()))
		{
			
		  return ResponseEntity
				.badRequest()
				.body("Error: Restaurant is already included!");
		}
		else
			
			restaurantDetailService.save(restaurant);

		return ResponseEntity.ok(restaurant);
	}
	@PutMapping("/{restaurantid}/iteminrestaurant/{itemid}")
	public ResponseEntity<?> itemsinrestaurants(@PathVariable Long restaurantid,@PathVariable Long itemid) {
		RestaurantData restaurantData=restaurantrepo.findAllByID(restaurantid);
		ItemsData itemsData=itemrepo.findAllByID(itemid);
		if(restaurantData==null)
		{
			 return ResponseEntity
						.badRequest()
						.body("Restaurant not found");
		}
		
		if(itemsData==null)
		{
			 return ResponseEntity
						.badRequest()
						.body("item not found");
			//itemdetails.save(itemdata);
			//itemrepo.save(itemdata);
		}
//		if (this.restaurantrepo.existsById(restaurantid)&&(this.itemrepo.existsById(itemid)))
//		{			
//		  return ResponseEntity
//				.badRequest()
//				.body("Error: Item is already included in the Restaurant!");
//		}
		restaurantData.items_restaurant(itemsData);
		restaurantrepo.save(restaurantData);
		
		return ResponseEntity.ok(restaurantData);
		
		
	}

}
