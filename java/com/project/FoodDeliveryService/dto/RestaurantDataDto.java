package com.project.FoodDeliveryService.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import com.project.FoodDeliveryService.Model.Roledata;

public class RestaurantDataDto {
	
	private String restaurantname;
	
	private String restaurantcontact;
	

	private String restaurantEmail;
	

	private String restaurantpassword;
	
	private String restaurantdescription;
	
	public String getRestaurantname() {
		return restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public String getRestaurantcontact() {
		return restaurantcontact;
	}

	public void setRestaurantcontact(String restaurantcontact) {
		this.restaurantcontact = restaurantcontact;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	public String getRestaurantpassword() {
		return restaurantpassword;
	}

	public void setRestaurantpassword(String restaurantpassword) {
		this.restaurantpassword = restaurantpassword;
	}

	public String getRestaurantdescription() {
		return restaurantdescription;
	}

	public void setRestaurantdescription(String restaurantdescription) {
		this.restaurantdescription = restaurantdescription;
	}

	

}