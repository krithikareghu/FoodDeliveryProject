package com.project.FoodDeliveryService.dto;

import javax.persistence.Column;

public class RestaurantDataDto {
	
	private String restaurantname;
	

	
	private String restaurantcontact;
	

	private String restaurantEmail;
	

	private String Restaurantpassword;
	
	private String Restaurantdescription;

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
		return Restaurantpassword;
	}

	public void setRestaurantpassword(String restaurantpassword) {
		Restaurantpassword = restaurantpassword;
	}

	public String getRestaurantdescription() {
		return Restaurantdescription;
	}

	public void setRestaurantdescription(String restaurantdescription) {
		Restaurantdescription = restaurantdescription;
	}
	

}
