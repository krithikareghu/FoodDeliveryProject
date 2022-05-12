package com.project.FoodDeliveryService.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.dto.UserDataDto;
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
    
    
     
    @Override
    public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException {
        UserData user = userRepo.findByPhonenumber(phonenumber);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return  new org.springframework.security.core.userdetails.User(user.getPhonenumber(), user.getPassword(),
				getauthorities(user));
    }
    
    private Set getauthorities(UserData user) {
    	Set authorities=new HashSet<>();	
    	
    	user.getRoles().forEach( role ->{
    		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
    		System.out.println(authorities);
    	}); 
    	return authorities;
    	
    }
    public UserData registeruser(UserDataDto user) {
    	
    	UserData newuser=new UserData();
    	newuser.setUsername(user.getUsername());
    	newuser.setPassword(brcyptEncoder.encode(user.getPassword()));
    	newuser.setEmail(user.getEmail());
    	newuser.setPhonenumber(user.getPhonenumber());
    	newuser.setAddress(user.getAddress());
    	Set<Roledata>userroles=new HashSet<>();
    	
    	
		Roledata userRoledata=roleRepository.findById("user").get();
		if(userRoledata==null)
		{
		   userRoledata=new Roledata();
			userRoledata.setRolename("user");
			userRoledata.setRoleDescription("Default role");
			
		}
	
		userroles.add(userRoledata);
    	newuser.setRoles(userroles);
	
		return  userRepo.save(newuser);
	}  
   
	
}