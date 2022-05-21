package com.project.FoodDeliveryService.Service;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
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
	public UserDetails loadUserByUsername(String restaurantcontact) throws UsernameNotFoundException {
		
		
		 RestaurantData restaurant = restaurantRepo.findByRestaurantcontact(restaurantcontact);
		
	        if (restaurant == null) {
	            throw new UsernameNotFoundException("restaurant not found");
	        }
	        return  new org.springframework.security.core.userdetails.User(restaurant.getRestaurantcontact(),restaurant.getRestaurantpassword(),
					getauthorities(restaurant));
		}

		private Set getauthorities(RestaurantData restaurant) {
			Set authorities = new HashSet<>();

			restaurant.getRoles().forEach(role -> {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
				System.out.println(authorities);
			});
			return authorities;

		}
	 public RestaurantData save(RestaurantDataDto restaurant) {
	    	
	    	RestaurantData newrestaurant=new RestaurantData();
	    	newrestaurant.setRestaurantname(restaurant.getRestaurantname());
	    	newrestaurant.setRestaurantEmail(restaurant.getRestaurantEmail());
	    	newrestaurant.setRestaurantpassword(brcyptEncoder.encode(restaurant.getRestaurantpassword()));   
	    	newrestaurant.setRestaurantcontact(restaurant.getRestaurantcontact());
	    	newrestaurant.setRestaurantdescription(restaurant.getRestaurantdescription());
	    
	    	
	    	Set<Roledata>userroles=new HashSet<>();
	    	
	    	Roledata userRoledata=roleRepository.findByrolename("owner");
			if(userRoledata==null)
			{
			   userRoledata=new Roledata();
				userRoledata.setRolename("restaurant owner");
				userRoledata.setRoleDescription("restaurant owner role");
				roleRepository.save(userRoledata);
				
			}
			
		
			userroles.add(userRoledata);
	    	newrestaurant.setRoles(userroles);
	    	
	   
			return  restaurantRepo.save(newrestaurant);
		}

}
