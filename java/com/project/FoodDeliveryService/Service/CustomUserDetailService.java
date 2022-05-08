package com.project.FoodDeliveryService.Service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.Model.UserDataDto;
import com.project.FoodDeliveryService.repository.UserRepository;
 @Component
public class CustomUserDetailService implements UserDetailsService {
	 
	 @Lazy
	 @Autowired
	 PasswordEncoder brcyptEncoder;
 
    @Autowired
    private UserRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException {
        UserData user = userRepo.findByPhonenumber(phonenumber);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return  new org.springframework.security.core.userdetails.User(user.getPhonenumber(), user.getPassword(),
				new ArrayList<>());
    }
    public UserData save(UserDataDto user) {
    	
    	UserData newuser=new UserData();
    	newuser.setUsername(user.getUsername());
    	newuser.setPassword(brcyptEncoder.encode(user.getPassword()));
    	newuser.setEmail(user.getEmail());
    	newuser.setPhonenumber(user.getPhonenumber());
    	newuser.setAddress(user.getAddress());
		return  userRepo.save(newuser);
	}
}