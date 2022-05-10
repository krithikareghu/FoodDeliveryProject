package com.project.FoodDeliveryService.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.dto.ItemDataDto;
import com.project.FoodDeliveryService.dto.UserDataDto;
import com.project.FoodDeliveryService.repository.ItemsRepository;
@Component
public class ItemsDetailsService implements UserDetailsService {
	
@Autowired
ItemsRepository itemRepo;

	@Override
	public UserDetails loadUserByUsername(String itemname) throws UsernameNotFoundException {
		
		
		 ItemsData item = itemRepo.findByItemname(itemname);
	        if (item == null) {
	            throw new UsernameNotFoundException("item not found");
	        }
	        return  new org.springframework.security.core.userdetails.User(item.getItemname() ,null, null);
	        		//User(item.getItemname(),
					//new ArrayList<>());
	}
	 public ItemsData save(ItemDataDto item) {
	    	
	    	ItemsData newitem=new ItemsData();
	    	newitem.setItemname(item.getItemname());
	   
			return  itemRepo.save(newitem);
		}

}
