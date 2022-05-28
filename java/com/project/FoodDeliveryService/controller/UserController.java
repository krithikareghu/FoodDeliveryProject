package com.project.FoodDeliveryService.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.dto.UserDataDto;
import com.project.FoodDeliveryService.jwt.JwtUtil;
import com.project.FoodDeliveryService.repository.RoleRepository;
import com.project.FoodDeliveryService.repository.UserRepository;

@RestController
//@RequestMapping("/user")
@CrossOrigin("${frontend.domain}")
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
		System.out.println("hii");

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

	@RequestMapping(value = "/user/updateuser", method = RequestMethod.PUT)
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

	@RequestMapping(value = "user/getuserdetails/{id}", method = RequestMethod.GET)
	public UserData getuserdetails(@PathVariable Long id) throws Exception {
	
      UserData userData=userrepo.findByID(id);
		if (userData!=null)
			{ 
			return userData;}
		else
		{  
			return null;
		}

	}

	@RequestMapping(value = "/user/addaddress/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<?> addaddress(@RequestBody UserDataDto useraddress,@PathVariable String userid) throws Exception {

		System.out.println(userid);
		 UserData userData=userrepo.findByID(Long.parseLong(userid));
		if (userData != null) {

			userData.setAddress(useraddress.getAddress());
			userrepo.save(userData);

			return ResponseEntity.ok(useraddress);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
//	@GetMapping("/token/refreshtoken")
//	public void refreshtoken(HttpServletRequest request,HttpServletResponse response)
//	{
//		String aut
//	}

}
