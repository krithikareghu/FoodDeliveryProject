package com.project.FoodDeliveryService.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.FoodDeliveryService.Model.Authenticaterestaurantresponse;
import com.project.FoodDeliveryService.Model.AuthenticationRequest;
import com.project.FoodDeliveryService.Model.AuthenticationResponse;
import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.SecurityConfig.JwtUtil;
import com.project.FoodDeliveryService.Service.ItemsDetailsService;
import com.project.FoodDeliveryService.Service.RestaurantDetailService;
import com.project.FoodDeliveryService.dto.RestaurantDataDto;
import com.project.FoodDeliveryService.dto.Restaurantdto;
import com.project.FoodDeliveryService.dto.UserDataDto;
import com.project.FoodDeliveryService.repository.CategoryRepository;
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
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Lazy
	@Autowired
	PasswordEncoder brcyptEncoder;
	
	@RequestMapping(value = "/addrestaurant", method = RequestMethod.POST)
	public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantDataDto restaurant) throws Exception {
	
		
		if (this.restaurantrepo.existsByrestaurantname(restaurant.getRestaurantname()))
		{
			
		  return ResponseEntity
				.badRequest()
				.body("Error: Restaurant is already included!");
		}
		else
		{
			restaurantDetailService.save(restaurant);
		return ResponseEntity.ok(restaurant);
		}
	}
	
	@RequestMapping(value = "/loginrestaurant", method = RequestMethod.POST)
	public ResponseEntity<?> loginrestaurant(@RequestBody Restaurantdto restaurant) throws Exception {

		//System.out.println(restaurant);

			authenticate(restaurant.getRestaurantcontact(), restaurant.getRestaurantpassword());
			
		    final UserDetails userDetails = restaurantDetailService.loadUserByUsername(restaurant.getRestaurantcontact());

			final String token = jwtUtil.generateToken(userDetails);
			RestaurantData restaurantData=restaurantrepo.findByRestaurantcontact(restaurant.getRestaurantcontact());

			return ResponseEntity.ok(new Authenticaterestaurantresponse(token,restaurantData));

		}

	
private void authenticate(String phonenumber, String password) throws Exception {
	try {
	
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phonenumber, password));
	} catch (DisabledException e) {
		throw new Exception("USER_DISABLED", e);
	} catch (BadCredentialsException e) {
		throw new Exception("INVALID_CREDENTIALS", e);
	}
}
	
	
	
	
	
	
	
	@RequestMapping(value = "/addrestaurantstocategory/{categoryid}/{restaurantid}", method = RequestMethod.PUT)
	public ResponseEntity<?>addrestaurantstocategory(@PathVariable Long categoryid,@PathVariable Long restaurantid){
		RestaurantData restaurantData=restaurantrepo.findByID(restaurantid);
		Categorydata categorydata=categoryRepository.findAllByID(categoryid);
		categorydata.restaurant_category(restaurantData);
		categoryRepository.save(categorydata);
		
		return ResponseEntity.ok(categorydata);
	}
	
	
	@RequestMapping(value = "/updaterestaurant", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRestaurant(@RequestBody RestaurantDataDto restaurant) throws Exception {
	
		if (this.restaurantrepo.existsByrestaurantname(restaurant.getRestaurantname()))
		{
			restaurantDetailService.save(restaurant);
			return ResponseEntity.ok(restaurant);

		  
		}
		else {
			return ResponseEntity
		
				.badRequest()
				.body("Error: Restaurant is not included");
			

			}
	}
	
	
	@PutMapping("/{restaurantname}/iteminrestaurant/{itemid}")
	public ResponseEntity<?> itemsinrestaurants(@PathVariable String restaurantname,@PathVariable Long itemid) {
		RestaurantData restaurantData=restaurantrepo.findAllByrestaurantname(restaurantname);
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
		//restaurantData.items_restaurant(itemsData);
		restaurantrepo.save(restaurantData);
		
		return ResponseEntity.ok(restaurantData);
		
		
	}


}