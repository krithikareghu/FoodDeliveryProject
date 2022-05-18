package com.project.FoodDeliveryService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.dto.ItemDataDto;
import com.project.FoodDeliveryService.dto.UserDataDto;
import com.project.FoodDeliveryService.repository.CategoryRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;
@Component
public class ItemsDetailsService implements UserDetailsService {
	
@Autowired
ItemsRepository itemRepo;
@Autowired
CategoryRepository categoryRepository;

	@Override
	public UserDetails loadUserByUsername(String itemname) throws UsernameNotFoundException {
		
		
		 ItemsData item = itemRepo.findByItemname(itemname);
	        if (item == null) {
	            throw new UsernameNotFoundException("item not found");
	        }
	       // return  new org.springframework.security.core.userdetails.User(item.getItemname() ,null, null);
	        		//User(item.getItemname(),
					//new ArrayList<>());
	        return null;
	}
	 public ItemsData save(ItemDataDto item) {
	    	
	    	ItemsData newitem=new ItemsData();
	    	//newitem.setItemname(item.getItemname());
	   
			return  itemRepo.save(newitem);
		}
	 
	 public List<ItemsData>getAllProducts(){
			return itemRepo.findAll();
		}
		public List<ItemsData>getProductsByCategory(String product_id){
			return itemRepo.getByCategoryId(product_id);
		}
		
		public List<Categorydata>getAllCategory(){
			return categoryRepository.findAll();
		}
		
		public ItemsData getitemsById(long productId) throws Exception {
			return itemRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
		}

}
