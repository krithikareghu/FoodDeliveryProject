package com.project.FoodDeliveryService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="checkout_cart")
public class Checkout_Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ID;
	String order_ID,payment_type,delivery_address;
	long user_ID;
	@OneToOne(fetch=FetchType.LAZY)
	  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "item_ID")
	ItemsData itemsData;	
	//long ;
	int qty;
	double price;
	@Column(updatable=false, insertable=false)
	String order_date;
	
	String restaurantname;
	
	public String getRestaurantname() {
		return restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID(String order_ID) {
		this.order_ID = order_ID;
	}
	public long getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(long user_ID) {
		this.user_ID = user_ID;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
//	public long getProduct_id() {
//		return product_id;
//	}
//	public void setProduct_id(long product_id) {
//		this.product_id = product_id;
//	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	public ItemsData getItemsData() {
		return itemsData;
	}
	public void setItemsData(ItemsData itemsData) {
		this.itemsData = itemsData;
	}
	
	
}