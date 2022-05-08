package com.project.FoodDeliveryService.controller;

import java.net.http.HttpHeaders;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.ItemDataDto;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.Model.UserDataDto;
import com.project.FoodDeliveryService.SecurityConfig.JwtUtil;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.Service.ItemsDetailsService;
import com.project.FoodDeliveryService.repository.ItemsRepository;
import com.project.FoodDeliveryService.repository.RestaurantRepository;
import com.project.FoodDeliveryService.repository.UserRepository;

import antlr.collections.List;

//@Controller
@RestController
@CrossOrigin("http://localhost:4200")
public class MainController {

//	@Autowired
//	private CustomUserDetailService userdetails;
//	
//	@Autowired
//	private ItemsDetailsService itemsdetails;
	
//	@Autowired
//	AuthenticationManager authenticationManager;
	
//	@Autowired
//	JwtUtil jwtUtils;


	
//	@Autowired
//	BCryptPasswordEncoder brcyptEncoder;
//	
	

	

	
	
	
	
	


	
} 

















/*
 * @PostMapping("/signupuser") public
 * ResponseEntity<UserDataDto>registeruser(@RequestBody UserDataDto user) {
 * userdetails.save(user); return null; }
 */	 

//@PostMapping("/login") 
//  public ResponseEntity<UserData> loginuser(@RequestBody UserDataDto userdata)throws Exception {
//  System.out.println(userdata); 
//  UserData user=userRepo.findByPhonenumber(userdata.getPhonenumber());
//  //UserDataDto user= this.userdetails.loadUserByUsername(userdata.getUsername());
//  
//  if((user.getPassword().equals(userdata.getPassword())) && (user.getUsername().equals(userdata.getUsername())))
//	  return ResponseEntity.ok(user);
//  return (ResponseEntity<UserData>) ResponseEntity.internalServerError();
//  
//  }

//@PostMapping("/signout")
  //public ResponseEntity<?> logoutUser() {
//    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
//        .body(new MessageResponse("You've been signed out!"));
//  }














//	@GetMapping("/signupuser")
//	public ModelAndView signupuser(UserData user) {
//
//		ModelAndView mvAndView = new ModelAndView();
//		String message = "";
//		if (userRepo.existsByUsername(user.getUsername())) {
//			mvAndView.addObject("message", "Already registered please login here");
//			mvAndView.setViewName("error.jsp");
//		} else {
//			userRepo.save(user);
//			mvAndView.setViewName("registerstatus.jsp");
//		}
//		return mvAndView;
//	}
//
//
//	@GetMapping("/loginuser")
//	public ModelAndView loginuser(UserData currentuser) {
//
//		ModelAndView modelAndView = new ModelAndView();
//		String message = "";
//		UserData user = userRepo.findByUsername(currentuser.getUsername());
//		if (user == null) {
//			modelAndView.addObject("message", "Does not have an account Please Register");
//			modelAndView.setViewName("error.jsp");
//			return modelAndView;
//		} else if (user.getPassword().equals(currentuser.getPassword())) {
//			modelAndView.setViewName("Welcome.jsp");
//			return modelAndView;
//
//		} else {
//			modelAndView.addObject("message", "Password Incorrect Login Again");
//			modelAndView.setViewName("error.jsp");
//			return modelAndView;
//		}
//
//	}
