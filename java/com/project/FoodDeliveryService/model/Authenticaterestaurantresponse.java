package com.project.FoodDeliveryService.Model;

public class Authenticaterestaurantresponse {
	
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private RestaurantData restaurantData;
	public RestaurantData getRestaurantData() {
		return restaurantData;
	}
	public void setRestaurantData(RestaurantData restaurantData) {
		this.restaurantData = restaurantData;
	}
	public String getJwttoken() {
		return jwttoken;
	}
	public Authenticaterestaurantresponse(String jwttoken, RestaurantData restaurantData) {
	
		this.jwttoken = jwttoken;
		this.restaurantData = restaurantData;
	}
	

}
