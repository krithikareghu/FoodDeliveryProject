package com.project.FoodDeliveryService.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.repository.CartRepository;
import com.project.FoodDeliveryService.repository.CategoryRepository;
import com.project.FoodDeliveryService.repository.CheckOutRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;
import com.project.FoodDeliveryService.repository.RestaurantRepository;
import com.project.FoodDeliveryService.repository.RoleRepository;
import com.project.FoodDeliveryService.repository.UserRepository;

@RestController
 //@CrossOrigin("http://localhost:4200")
@CrossOrigin("${frontend.domain}")


public class AdminController {
	@Autowired
	ItemsRepository itemrepo;

	@Autowired
	UserRepository userrepo;

	@Autowired
	RestaurantRepository restaurantrepo;

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CheckOutRepository checkOutRepository;

	@Autowired
	CustomUserDetailService customUserDetailService;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/admin/allusers")
	public java.util.List<UserData> getallusers() {
		return userrepo.findAll();
	}

	@GetMapping("/admin/allitems")
	public java.util.List<ItemsData> getallitems() {
		return itemrepo.findAll();
	}

	@GetMapping("/admin/allcategories")
	public java.util.List<Categorydata> getallcategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/admin/allrestaurantdetails")
	public java.util.List<RestaurantData> getallrestaurantdetails() {
		return restaurantrepo.findAll();
	}

	@GetMapping("category/getrestaurantsfromcategory/{categoryid}")
	public Set<RestaurantData> getrestaurantsbycategory(@PathVariable Long categoryid) {

		Categorydata categorydata = categoryRepository.findAllByID(categoryid);
		Set<RestaurantData> restaurants = categorydata.getCategory_restaurants();
		return restaurants;

	}

	@GetMapping("category/getitemsfromrestaurants/{restaurantname}")
	public Set<ItemsData> getitemsfromrestaurants(@PathVariable String restaurantname) {

		RestaurantData restaurantData = restaurantrepo.findByRestaurantname(restaurantname);

		Set<ItemsData> items = restaurantData.getItems();
		ItemsData item = new ItemsData();

		return items;

	}

	@GetMapping("category/itempic/{restaurantname}")
	public List categorypics(@PathVariable String restaurantname) {
		List<String> list = new ArrayList<String>();
		RestaurantData restaurantData = restaurantrepo.findAllByrestaurantname(restaurantname);
		Set<ItemsData> itemspic = restaurantData.getItems();
		for (ItemsData category : itemspic) {
			byte[] file = category.getItempicture();
			String encodebase64 = null;
			encodebase64 = Base64.getEncoder().encodeToString(file);
			list.add("data:image/jpeg;base64," + encodebase64);
		}
		System.out.println("hi");
		return list;
	}

	@GetMapping("/admin/itempics")
	//@PreAuthorize("hasRole('Admin')")
	public List categorypics() {
		List<String> list = new ArrayList<String>();
		List<byte[]> pics = itemrepo.finditempictures();

		for (byte[] category : pics) {

			String encodebase64 = null;
			encodebase64 = Base64.getEncoder().encodeToString(category);
			list.add("data:image/jpeg;base64," + encodebase64);
		}
		return list;
	}

	@GetMapping("/admin/allrestaurants")
	@PreAuthorize("hasRole('Admin')")
	public List<RestaurantData> getallrestaurants() {
		List<String> restaurants = new ArrayList<String>();
		for (RestaurantData restaurantData : restaurantrepo.findAll()) {
			restaurants.add(restaurantData.getRestaurantname());
		}

		return restaurantrepo.findAll();

	}

	@DeleteMapping("/admin/deleterestaurant/{restaurantname}")
	public List<RestaurantData> deleterestaurant(@PathVariable String restaurantname) {
		
		RestaurantData restaurant = restaurantrepo.findByRestaurantname(restaurantname);
		restaurantrepo.delete(restaurant);
		List<RestaurantData> restaurantData = restaurantrepo.findAll();
		return restaurantData;
	}

	@DeleteMapping("/admin/deleteitems/{id}")
	public List<ItemsData> deleteitems(@PathVariable String id) {
		// ItemsData items=itemrepo.findAllByID(id);
		cartRepository.deletebyitemId(Long.parseLong(id));
		checkOutRepository.deleteitems(Long.parseLong(id));
		itemrepo.deleteById(Long.parseLong(id));
		List<ItemsData> itemsDatas = itemrepo.findAll();

		return itemsDatas;
	}
	@DeleteMapping("/admin/deletecategory/{id}")
	public List<Categorydata> deletecategory(@PathVariable String id) {
		
		// ItemsData items=itemrepo.findAllByID(id);
//		cartRepository.deletebyitemId(Long.parseLong(id));
//		checkOutRepository.deleteitems(Long.parseLong(id));
		categoryRepository.deleteById(Long.parseLong(id));
		List<Categorydata> categorydatas = categoryRepository.findAll();

		return categorydatas;
	}

	@DeleteMapping("/admin/deleteuser/{id}")
	public List<UserData> deleteuser(@PathVariable String id) {

		UserData user = userrepo.findByID(Long.parseLong(id));
		userrepo.delete(user);
		List<UserData> userDatas = userrepo.findAll();
		return userDatas;
	}

}
