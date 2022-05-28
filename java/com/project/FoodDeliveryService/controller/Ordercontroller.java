package com.project.FoodDeliveryService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodDeliveryService.Model.CartData;
import com.project.FoodDeliveryService.Model.Checkout_Cart;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.UserData;
import com.project.FoodDeliveryService.SecurityConfig.CartConfiguration;
import com.project.FoodDeliveryService.Service.CartService;
import com.project.FoodDeliveryService.Service.CustomUserDetailService;
import com.project.FoodDeliveryService.jwt.JwtUtil;
import com.project.FoodDeliveryService.repository.CartRepository;
import com.project.FoodDeliveryService.repository.CheckOutRepository;

import com.project.FoodDeliveryService.repository.UserRepository;

@RestController
@CrossOrigin("${frontend.domain}")
public class Ordercontroller {
	
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	UserRepository userrepo;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartService cartService;
	@Autowired
	CustomUserDetailService customUserDetailService;
	@Autowired
	CheckOutRepository checkOutRepository;
	

	@RequestMapping("user/checkout_order")
  	public ResponseEntity<?> checkout_order(@RequestBody HashMap<String,String> addCartRequest) {

		System.out.println(addCartRequest);
		
		try {
			String keys[] = {"total_price","pay_type","deliveryAddress","userId"};
			if(CartConfiguration.validationWithHashMap(keys, addCartRequest)) {		
			}
			
			long user_Id = Long.parseLong(addCartRequest.get("userId"));
			double total_amt = Double.parseDouble(addCartRequest.get("total_price"));
			if(cartService.checkTotalAmountAgainstCart(total_amt,user_Id)) {
				List<CartData> cartItems = cartService.getCartByUserId(user_Id);
				List<Checkout_Cart> tmp = new ArrayList<Checkout_Cart>();
				for(CartData addCart : cartItems) {
					String orderId = ""+getOrderId();
					Checkout_Cart cart = new Checkout_Cart();
					cart.setPayment_type(addCartRequest.get("pay_type"));
					cart.setPrice(total_amt);
					cart.setUser_ID(user_Id);
					cart.setOrder_ID(orderId);
					cart.setItemsData(addCart.getItemsData());
					cart.setQty(addCart.getQty());
					cart.setDelivery_address(addCartRequest.get("deliveryAddress"));
					tmp.add(cart);
				}
				cartService.saveItemsForCheckout(tmp);
			  System.out.println("hii");
				return ResponseEntity.ok("Order placed successfully");
			}else {
				
				throw new Exception("Total amount is mismatch");
			}
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body("error");
		}
	}
	public int getOrderId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	@RequestMapping("user/getOrdersByUserId/{userid}")
		public ResponseEntity<?> getOrdersByUserId(@PathVariable String userid) {
		
		   long user_id =Long.parseLong(userid);
		 
		try {
		 List<Checkout_Cart> checkoutsCarts=checkOutRepository.getByuserId(user_id);
			return ResponseEntity.ok(checkoutsCarts);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("error");
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/order")
//	public void order(@RequestHeader String token,@PathVariable OrderData orders ) {
//		String phonenumber = jwtUtil.getUsernameFromToken(token);
//		UserData userData = this.userrepo.findByPhonenumber(phonenumber);
//		userData.setorder(orders);
//		userrepo.save(userData);
//	}
	
	//@PostMapping("/addtocart")
//	public void addtocart(@RequestHeader String token,@RequestBody CartData order)
	{
//	System.out.println(token);
//		String phonenumber = jwtUtil.getUsernameFromToken(token);
//		UserData userData = this.userrepo.findByPhonenumber(phonenumber);
//		if(!userData.getCartDatas().contains(order)) {
//			userData.setcart(order);
//		}
//		cartRepository.save(order);
//		userrepo.save(userData);		
		
	}

//	@DeleteMapping("/removefromcart")
	//public void removefromcart(@RequestHeader String token,@PathVariable CartData orderitems) {
//		String phonenumber = jwtUtil.getUsernameFromToken(token);
//		UserData userData = this.userrepo.findByPhonenumber(phonenumber);
//        userData.removecartitems(orderitems);
//       
//		userrepo.save(userData);
//	}
	
	

	//public Set<CartData> getcartitems(@RequestHeader String token) {
//		String phonenumber = jwtUtil.getUsernameFromToken(token);
//		UserData userData = this.userrepo.findByPhonenumber(phonenumber);
//		System.out.println(userData.getCartDatas());
//		return userData.getCartDatas();
		
		//return  null;
	//}
//	@PutMapping ("/increment_quantity")
//	void incrementquantity(@RequestHeader String token, @PathVariable CartData cartitems){
//		String phonenumber = jwtUtil.getUsernameFromToken(token);
//		UserData userData = this.userrepo.findByPhonenumber(phonenumber);
//		cartRepository.updatequantity(cartitems.getID());
//		//cartRepository.save(null)
//		
//		
//	}
	
//	@GetMapping("/getcartitems")
//	public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
//		try {
//			String keys[] = {"productId","userId","quantity","price"};
//			if(CartConfiguration.validationWithHashMap(keys, addCartRequest)) {		
//			}
//			long productId = Long.parseLong(addCartRequest.get("productId")); 
//			long userId =  Long.parseLong(addCartRequest.get("userId")); 
//			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
//			double price = Double.parseDouble(addCartRequest.get("price"));
//			List<CartData> obj = cartService.addCartbyUserIdAndProductId(productId,userId,qty,price);
//			return ResponseEntity.ok(obj);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.badRequest().body("error");
//		}
//		
//   }
}
