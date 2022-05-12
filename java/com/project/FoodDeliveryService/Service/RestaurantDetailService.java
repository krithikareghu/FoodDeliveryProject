package com.project.FoodDeliveryService.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.dto.RestaurantDataDto;
import com.project.FoodDeliveryService.repository.RestaurantRepository;
import com.project.FoodDeliveryService.repository.RoleRepository;

@Component
public class RestaurantDetailService implements UserDetailsService {
@Autowired
RestaurantRepository restaurantRepo;

@Lazy
@Autowired
PasswordEncoder brcyptEncoder;

@Autowired
RoleRepository roleRepository;

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
	    	newrestaurant.setRestaurantEmail(restaurant.getRestaurantEmail());
	    	newrestaurant.setRestaurantpassword(brcyptEncoder.encode(restaurant.getRestaurantpassword()));   
	    	newrestaurant.setRestaurantcontact(restaurant.getRestaurantcontact());
	    	newrestaurant.setRestaurantdescription(restaurant.getRestaurantdescription());
	    	
	    	Set<Roledata>userroles=new HashSet<>();
	    	
	    	Roledata userRoledata=null;
	    	//=roleRepository.findById("restaurant owner").get();
			if(userRoledata==null)
			{
			   userRoledata=new Roledata();
				userRoledata.setRolename("restaurant owner");
				userRoledata.setRoleDescription("restaurant owner role");
				
			}
		
			userroles.add(userRoledata);
	    	//newrestaurant.setRoles(userroles);
	    	
	   
			return  restaurantRepo.save(newrestaurant);
		}

}
