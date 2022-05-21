package com.project.FoodDeliveryService.dto;

public class Restaurantdto {
private String restaurantcontact;

	private String restaurantpassword;

	public Restaurantdto(String restaurantcontact, String restaurantpassword) {
	this.restaurantcontact = restaurantcontact;
		this.restaurantpassword = restaurantpassword;
	}

	public String getRestaurantcontact() {
		return restaurantcontact;
	}

	public void setRestaurantcontact(String restaurantcontact) {
		this.restaurantcontact = restaurantcontact;
	}





	public String getRestaurantpassword() {
		return restaurantpassword;
	}





	public void setRestaurantpassword(String restaurantpassword) {
		this.restaurantpassword = restaurantpassword;
	}
	

}
