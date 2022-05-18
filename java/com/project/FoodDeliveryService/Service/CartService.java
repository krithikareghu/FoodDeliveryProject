package com.project.FoodDeliveryService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.FoodDeliveryService.Model.CartData;
import com.project.FoodDeliveryService.Model.Checkout_Cart;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.repository.CartRepository;
import com.project.FoodDeliveryService.repository.CheckOutRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;

@Component
public class CartService {
	
	
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ItemsRepository itemsRepository;
	@Autowired
	ItemsDetailsService itemsDetailsService;
	@Autowired
	CheckOutRepository checkOutRepository;
	
	public List<CartData> addCartbyUserIdAndItemId(long itemId, long userId,int qty,double price,String itemname) throws Exception {
		try {
			if(cartRepository.getCartByitemIdAnduserId(userId, itemId).isPresent()){
				throw new Exception("Product already exist.");
			}
			CartData cart = new CartData();
			cart.setQty(qty);
			cart.setUser_ID(userId);
			cart.setItemname(itemname);
			ItemsData item = itemsDetailsService.getitemsById(itemId);
			cart.setItemsData(item);
			//TODO price has to check with qty
			cart.setPrice(price);
			cartRepository.save(cart);		
			return this.getCartByUserId(userId);	
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	public List<CartData> getCartByUserId(long userId) {
		return cartRepository.getCartByuserId(userId);
	}
	

	public List<CartData> removeCartByUserId(long cartId, long userId) {
		cartRepository.deleteCartByIdAndUserId(userId, cartId);
		return this.getCartByUserId(userId);
	}


	public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
		cartRepository.updateQtyByCartId(cartId,price,qty);
	}

	
	public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
		double total_amount =cartRepository.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}


	public List<Checkout_Cart> getAllCheckoutByUserId(long userId) {
		return checkOutRepository.getByuserId(userId);
	}


	public List<Checkout_Cart> saveItemsForCheckout(List<Checkout_Cart> tmp) throws Exception {
		try {
			long user_id = tmp.get(0).getUser_ID();
			if(tmp.size() >0) {
				checkOutRepository.saveAll(tmp);
				this.removeAllCartByUserId(user_id);
				return this.getAllCheckoutByUserId(user_id);
			}	
			else {
				throw  new Exception("Should not be empty");
			}
		}catch(Exception e) {
			throw new Exception("Error while checkout "+e.getMessage());
		}
		
	}

	
	public List<CartData> removeAllCartByUserId(long userId) {
		cartRepository.deleteAllCartByUserId(userId);
		return null;
	}


}
