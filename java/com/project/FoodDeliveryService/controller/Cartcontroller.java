package com.project.FoodDeliveryService.controller;

import java.io.Console;
import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.CartData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.SecurityConfig.CartConfiguration;
import com.project.FoodDeliveryService.SecurityConfig.JwtUtil;
import com.project.FoodDeliveryService.Service.CartService;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.repository.UserRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class Cartcontroller {

	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartService cartService;

	@Autowired
	CustomUserDetailService customUserDetailService;
	@PostMapping("additemtocart")
  	public ResponseEntity<?> addCartwithitem(@RequestBody HashMap<String,String> addCartRequest) {
		try {
	
			String keys[] = {"itemID","qty","price","userId"};
			if(CartConfiguration.validationWithHashMap(keys, addCartRequest)) {
				
			}
			long itemid = Long.parseLong(addCartRequest.get("itemID")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			String itemname=addCartRequest.get("itemname");
			List<CartData> obj = cartService.addCartbyUserIdAndItemId(itemid,userId,qty,price,itemname);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body("error");
		}
		
   }
	
	@RequestMapping("updateQtyForCart")
  	public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String,String> updateCartRequest) {
		
		try {
			String keys[] = {"cartId","userId","qty","price"};
			if(CartConfiguration.validationWithHashMap(keys, updateCartRequest)) {
				
			}
			long cartId = Long.parseLong(updateCartRequest.get("cartId")); 
			long userId =  Long.parseLong(updateCartRequest.get("userId")); 
			int qty =  Integer.parseInt(updateCartRequest.get("qty")); 		
			double price = Double.parseDouble(updateCartRequest.get("price"));
			 cartService.updateQtyByCartId(cartId, qty, price);
			 List<CartData> obj = cartService.getCartByUserId(userId);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("error");
		}
		
   }
	
	
	@DeleteMapping("removeItemFromCart")
  	public ResponseEntity<?> removeCartwithitemId(@RequestParam  HashMap<String,String> removeCartRequest) {
	
		System.out.println(removeCartRequest);
	System.out.println(	removeCartRequest.get("CartId"));
		try {
			String keys[] = {"userId","cartId"};
			
			if(CartConfiguration.validationWithHashMap(keys, removeCartRequest)) {
				
				
			}
			List<CartData> obj = cartService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Long.parseLong(removeCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
			System.out.println("helloo");
				return ResponseEntity.badRequest().body("error");
		}		
   }
	
	@GetMapping("getCartsByUserId/{userid}")
  	public ResponseEntity<?> getCartsByUserId(@PathVariable String userid) {
	System.out.println(userid);
		try {
			System.out.println(userid);
			//String keys[] = {"userId"};
			//if(CartConfiguration.validationWithHashMap(keys, getCartRequest)) {
				//			}
			
			List<CartData> obj = cartService.getCartByUserId(Long.parseLong(userid));
			return ResponseEntity.ok(obj);
		}catch(Exception e) 
		{
			System.out.println("error");
			return ResponseEntity.badRequest().body("error");
		}	
   }
	
	
}
