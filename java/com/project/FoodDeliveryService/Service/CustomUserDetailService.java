package com.project.FoodDeliveryService.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.dto.UserDataDto;
import com.project.FoodDeliveryService.jwt.JwtUtil;
import com.project.FoodDeliveryService.repository.RoleRepository;
import com.project.FoodDeliveryService.repository.UserRepository;

@Component
// @Transactional
public class CustomUserDetailService implements UserDetailsService {

	
	@Lazy
	@Autowired
	PasswordEncoder brcyptEncoder;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepo;
	@Autowired
	JwtUtil jwtUtil;

	@Override
	public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException {
		UserData user = userRepo.findByPhonenumber(phonenumber);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getPhonenumber(), user.getPassword(),
				getAuthorities(user));
	}
	public Collection<? extends GrantedAuthority> getAuthorities(UserData user) {
		//Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		ArrayList<GrantedAuthority> roles=new ArrayList<GrantedAuthority>();
				user.getRoles().forEach(role -> {
					roles.add(new SimpleGrantedAuthority(role.getRolename()));
					System.out.println(roles);
				});
				return roles;
		
	}


//	private Set<SimpleGrantedAuthority> getauthorities(UserData user) {
//		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//
//		user.getRoles().forEach(role -> {
//			authorities.add(new SimpleGrantedAuthority(role.getRolename()));
//			System.out.println(authorities);
//		});
//		return authorities;
//
//	}
	

	public UserData registeruser(UserDataDto user) {
		System.out.println("hii");
		System.out.println(user.getEmail());

		UserData newuser = new UserData();
		newuser.setUsername(user.getUsername());
		newuser.setPassword(brcyptEncoder.encode(user.getPassword()));
		newuser.setEmail(user.getEmail());
		newuser.setPhonenumber(user.getPhonenumber());
		newuser.setAddress(user.getAddress());

		if (user.getPhonenumber().equals("8825724096")) {
			Roledata adminRole = new Roledata();

			adminRole.setRolename("Admin");

			adminRole.setRoleDescription("admin role");
			Set<Roledata> userroles = new HashSet<>();

			userroles.add(adminRole);

			newuser.setRoles(userroles);
			roleRepository.save(adminRole);

		} else {
			System.out.println(user.getPhonenumber());

			Set<Roledata> userroles = new HashSet<>();
			Roledata userRoledata = roleRepository.findByrolename("User");
			if (userRoledata == null) {

				userRoledata = new Roledata();
				userRoledata.setRolename("User");
				userRoledata.setRoleDescription("Default role");
				roleRepository.save(userRoledata);
			}
			userroles.add(userRoledata);
			newuser.setRoles(userroles);

		}
		userRepo.save(newuser);
		return null;
	}

	public UserData getuserid(String jwttoken) {
		String phonenumber = jwtUtil.getUsernameFromToken(jwttoken);
		UserData userData = this.userRepo.findByPhonenumber(phonenumber);
		return userData;

	}

}