package com.project.FoodDeliveryService.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.dto.Categorydto;
import com.project.FoodDeliveryService.dto.ItemDataDto;
import com.project.FoodDeliveryService.repository.CategoryRepository;
@Component
public class CategoryDetailsService implements UserDetailsService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public UserDetails loadUserByUsername(String categoryname) throws UsernameNotFoundException {
		
		
		 Categorydata category = categoryRepo.findBycategoryname(categoryname);
	        if (category == null) {
	            throw new UsernameNotFoundException("category not found");
	        }
	        return  new org.springframework.security.core.userdetails.User(category.getCategoryname() ,null, null);
	   
	}
	 public Categorydata save(Categorydto category) {
	    	
	    	Categorydata newcategory=new Categorydata();
	    	newcategory.setCategoryname(category.getCategoryname());
	   
			return  categoryRepo.save(newcategory);
		}
	
	

	

}
