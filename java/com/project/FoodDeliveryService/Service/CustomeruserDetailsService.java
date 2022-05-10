package com.project.FoodDeliveryService.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.repository.RoleRepository;
import com.project.FoodDeliveryService.repository.UserRepository;
@Component
public class CustomeruserDetailsService {
	
	 @Autowired
	 private RoleRepository rolerepo;
	 
 @Autowired
 private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepo;
	
	 public ResponseEntity<?> addroletouser(String phonenumber,String rolename) {
	    	UserData userData=userRepo.findByPhonenumber(phonenumber);
	    	if(userData==null)
	    	{
	 
	    		return ResponseEntity.badRequest().body("user doesn't exists");
	    	}
	    	
	    	Roledata roledata= rolerepo.findByrolename(rolename);
	    	
	    	  userData.getRoles().add(roledata);
	    	  System.out.println(userData.getRoles());
	    	System.out.println(rolename + phonenumber);
	    	return ResponseEntity.ok(roledata);
	    
			
		}
	    
	    public void initRolesandUser() {
	    	Roledata adminRoledata=new Roledata();
	    	adminRoledata.setRolename("Admin");
	    	adminRoledata.setRoleDescription("admin role");
	    	rolerepo.save(adminRoledata);
	    	
	    	Roledata userRoledata=new Roledata();
	    	userRoledata.setRolename("user");
	    	userRoledata.setRoleDescription("Default role");
	    	rolerepo.save(userRoledata);
	    	
	    	UserData adminuserData=new UserData();
	    	adminuserData.setPhonenumber("8825724096");
	    	adminuserData.setEmail("admin@gmail.com");
	    	adminuserData.setUsername("admin123");
	    	adminuserData.setPassword(passwordEncoder.encode("admin"));;
	    	Set<Roledata>adminroles=new HashSet<Roledata>();
	    	adminroles.add(adminRoledata);
	    	adminuserData.setRoles(adminroles);
	    	userRepo.save(adminuserData);
	    	
	    	UserData userData=new UserData();
	    	userData.setPhonenumber("9925724096");
	    	userData.setEmail("user@gmail.com");
	    	userData.setUsername("user123");
	    	userData.setPassword(passwordEncoder.encode("user"));
	    	Set<Roledata>userroles=new HashSet<Roledata>();
	    	userroles.add(userRoledata);
	    	userData.setRoles(userroles);
	    	userRepo.save(userData);
	  
	    }

}
