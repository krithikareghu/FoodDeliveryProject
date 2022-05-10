package com.project.FoodDeliveryService.Model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private UserData userData;

	public AuthenticationResponse(String jwttoken, UserData userData) {
		this.jwttoken = jwttoken;
		this.userData = userData;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public AuthenticationResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}