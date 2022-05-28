package com.project.FoodDeliveryService.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.Roledata;
import com.project.FoodDeliveryService.Service.ItemsDetailsService;
import com.project.FoodDeliveryService.dto.ItemDataDto;
import com.project.FoodDeliveryService.repository.CategoryRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;
import com.project.FoodDeliveryService.repository.RestaurantRepository;

@RestController
@CrossOrigin("${frontend.domain}")
public class ItemsController {

	@Autowired
	ItemsRepository itemrepo;

	@Autowired
	private ItemsDetailsService itemsdetails;
	
	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/admin/additem", method = RequestMethod.POST)
	public ResponseEntity<?> saveitem(@RequestParam("myFile") MultipartFile file, @RequestParam String itemname,
			@RequestParam String itemprice)throws Exception {

		if (this.itemrepo.existsByitemname(itemname)) {

			return ResponseEntity.badRequest().body("Error: item is already included!");
		} else {

			ItemsData itemsData = new ItemsData();
			itemsData.setItemname(itemname);
			itemsData.setItemprice(itemprice);
			itemsData.setItempicture(file.getBytes());


			final ItemsData newitemData = itemrepo.save(itemsData);
			return ResponseEntity.ok(newitemData);
		}

	}
	
	@PostMapping("/category/additemstorestaurant/{itemid}/{restaurantid}")
	public ResponseEntity<?> additemstocategory(@PathVariable Long itemid, @PathVariable Long restaurantid) {

		RestaurantData restaurantData=restaurantRepository.findByID(restaurantid);
		ItemsData items=itemrepo.findAllByID(itemid);
		
	if(	restaurantData.items_restaurant(items)==true)
	{
		return ResponseEntity.ok("item already added");
		
	}
	
		restaurantRepository.save(restaurantData);

		return ResponseEntity.ok(restaurantData);

	}


	@GetMapping("/getitem")
	public Set<ItemsData> getitem(@RequestBody String categoryname) {

		ItemsData itemsData = new ItemsData();
		Categorydata categorydata = categoryRepository.findBycategoryname(categoryname);
		//Set<ItemsData> category_ItemsData = categorydata.getCategory_ItemsDatas();

		return null;

	}
	
	
	@GetMapping("/getitembyid/{itemid}")
	public Optional<ItemsData> getitembyid(@PathVariable Long itemid)
	{
		System.out.println(itemid);
		Optional<ItemsData> items=itemrepo.findById(itemid);
		System.out.println(items);
		return items;
	}
	

}


