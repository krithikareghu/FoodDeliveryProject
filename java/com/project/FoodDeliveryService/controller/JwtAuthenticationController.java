package com.project.FoodDeliveryService.controller;

import java.io.Console;
import java.lang.reflect.Array;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.AuthenticationRequest;
import com.project.FoodDeliveryService.Model.AuthenticationResponse;
import com.project.FoodDeliveryService.Model.LoginData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.Model.UserDataDto;
import com.project.FoodDeliveryService.SecurityConfig.JwtUtil;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@RestController
@CrossOrigin("http://localhost:4200")
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private JwtUtil jwtTokenUtil;

//	 @Lazy
//	 @Autowired
//	 PasswordEncoder passwordEncoder;

	@Autowired
	BCryptPasswordEncoder brcyptEncoder;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	JwtUtil jwtUtil;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDataDto user) throws Exception {

		if (this.userrepo.existsByUsername(user.getUsername()))
		  return ResponseEntity
				.badRequest()
				.body("Error: Username is already taken!");
	
	if (this.userrepo.existsByEmail(user.getEmail())) {
		return ResponseEntity
				.badRequest()
				.body("Error: Email is already in use!");
	}
		else
			customUserDetailService.save(user);

		return ResponseEntity.ok(user);
	}

	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = customUserDetailService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));

	}
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

//	@PostMapping("/login")
//	public ResponseEntity<?> loginuser(@RequestBody UserDataDto userdata,
//			@RequestHeader(value = "accept") String headers,
//			@RequestHeader(value = "Authorization") String authorisationheaders)throws Exception {
//
//		//if (jwtUtil.validateToken(authorisationheaders, userdata)) {
//			UserData user = this.userrepo.findByPhonenumber(userdata.getPhonenumber());
//
//			if ((brcyptEncoder.matches(userdata.getPassword(), user.getPassword()))
//					&& (user.getPhonenumber().equals(userdata.getPhonenumber()))) {
//				// System.out.println(userdata.getPhonenumber());
//
//				return ResponseEntity.ok(user);
//				// return new ResponseEntity<>(user,HttpStatus.FOUND);
//			}
//			return (new ResponseEntity<>(HttpStatus.NOT_FOUND));
//
//		}
		//else {
		//	return ResponseEntity.status(HttpStatus.OK).body(authorisationheaders);
		//}
//	
//	@RequestMapping(value = "/addaddress", method = RequestMethod.POST)
//	public ResponseEntity<?> saveUser(@RequestBody UserDataDto user) throws Exception {
//		System.out.println();
//		return ResponseEntity.ok(customUserDetailService.save(user));
//	}

	
}