package com.project.FoodDeliveryService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.RestaurantDataDto;
import com.project.FoodDeliveryService.repository.RestaurantRepository;

@Component
public class RestaurantDetailService implements UserDetailsService {
@Autowired
RestaurantRepository restaurantRepo;

	@Override
	public UserDetails loadUserByUsername(String restaurantname) throws UsernameNotFoundException {
		
		
		 RestaurantData restaurant = restaurantRepo.findByRestaurantname(restaurantname);
	        if (restaurant == null) {
	            throw new UsernameNotFoundException("restaurant not found");
	        }
	        return  new org.springframework.security.core.userdetails.User(restaurant.getRestaurantname() ,null, null);
	        	
	}
	 public RestaurantData save(RestaurantDataDto restaurant) {
	    	
	    	RestaurantData newrestaurant=new RestaurantData();
	    	newrestaurant.setRestaurantname(restaurant.getRestaurantname());
	   
			return  restaurantRepo.save(newrestaurant);
		}

}
