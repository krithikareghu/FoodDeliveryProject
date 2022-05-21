package com.project.FoodDeliveryService.controller;

import java.io.Console;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.SecurityConfig.JwtUtil;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.dto.UserDataDto;
import com.project.FoodDeliveryService.repository.RoleRepository;
import com.project.FoodDeliveryService.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	UserRepository userrepo;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	BCryptPasswordEncoder brcyptEncoder;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	JwtUtil jwtUtil;

	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDataDto user) throws Exception {

		if (this.userrepo.existsByUsername(user.getUsername()))

			return ResponseEntity.badRequest().body("Error: Username is already taken!");

		if (this.userrepo.existsByEmail(user.getEmail())) {
			return ResponseEntity.badRequest().body("Error: Email is already in use!");
		}
		if (this.userrepo.existsByPhonenumber(user.getPhonenumber())) {
			return ResponseEntity.badRequest().body("Error: Phonenumber is already in use!");
		} else {

			customUserDetailService.registeruser(user);
		}

		return ResponseEntity.ok(user);
	}

	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('user')")
	public ResponseEntity<?> updateUser(@RequestBody UserDataDto user) throws Exception {

		UserData userData = this.userrepo.findByUsername(user.getUsername());

		if (this.userrepo.existsByUsername(user.getUsername())) {
			userData.setUsername(user.getUsername());
			//userData.setPassword(brcyptEncoder.encode(user.getPassword()));
			userData.setAddress(user.getAddress());
			userData.setEmail(user.getEmail());
//			userData.setPhonenumber(user.getPhonenumber());

			return new ResponseEntity<>(userrepo.save(userData), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(value = "/getuserdetails/{id}", method = RequestMethod.GET)
	// @PreAuthorize("hasRole('user')")
	public UserData getuserdetails(@PathVariable Long id) throws Exception {
	System.out.println("hii");
      UserData userData=userrepo.findByID(id);
		if (userData!=null)
			{  System.out.println("hoiii");
			return userData;}
		else
		{  System.out.println("hoiii");
			return null;
		}

	}

	@RequestMapping(value = "/addaddress", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('user')")
	public ResponseEntity<?> addaddress(@RequestBody UserDataDto user, @RequestParam String jwttoken) throws Exception {

		// UserData userData = this.userrepo.findByPhonenumber(user.getPhonenumber());
		// System.out.println(user.getUsername());
		// System.out.println(user.getUsername().getClass());

		String username = jwtUtil.getUsernameFromToken(jwttoken);
		if (username != null) {
			UserData userData = this.userrepo.findByPhonenumber(username);

			userData.setAddress(user.getAddress());
			userrepo.save(userData);

			return ResponseEntity.ok(user);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
//	@GetMapping("/token/refreshtoken")
//	public void refreshtoken(HttpServletRequest request,HttpServletResponse response)
//	{
//		String aut
//	}

}
