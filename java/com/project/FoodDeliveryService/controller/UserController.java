package com.project.FoodDeliveryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.Model.UserDataDto;
import com.project.FoodDeliveryService.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	BCryptPasswordEncoder brcyptEncoder;
	
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserDataDto user) throws Exception {
		
		
		UserData userData = this.userrepo.findByUsername(user.getUsername());

		if (this.userrepo.existsByUsername(user.getUsername())) {
			userData.setUsername(user.getUsername());
			userData.setAddress(user.getAddress());
			userData.setPassword(brcyptEncoder.encode(user.getPassword()));
			userData.setAddress(user.getAddress());
			userData.setEmail(user.getEmail());
			userData.setPhonenumber(user.getPhonenumber());

			return new ResponseEntity<>(userrepo.save(userData), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(value = "/getuserdetails", method = RequestMethod.GET)
	public UserData getuserdetails(@RequestParam String phonenumber) throws Exception {
		// System.out.println(phonenumber);
		// System.out.println(phonenumber.getClass());
		// System.out.println(userData);
		// System.out.println(this.userrepo.existsByPhonenumber(phonenumber));
		UserData userData = this.userrepo.findByPhonenumber(phonenumber);

		if (this.userrepo.existsByPhonenumber(phonenumber))
			return userData;
		else
			return null;

	}
	
	@RequestMapping(value = "/addaddress", method = RequestMethod.PUT)
	public ResponseEntity<?> addaddress(@RequestBody UserDataDto user) throws Exception {

		UserData userData = this.userrepo.findByUsername(user.getUsername());
		System.out.println(user.getUsername());
		System.out.println(user.getUsername().getClass());

		if (this.userrepo.existsByUsername(user.getUsername())) {
			userData.setAddress(user.getAddress());
			userrepo.save(userData);

			return ResponseEntity.ok(user);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
