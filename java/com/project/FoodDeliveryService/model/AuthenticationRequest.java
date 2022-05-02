package com.project.FoodDeliveryService.Model;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable
{

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
//	private String email;
//	private String phonenumber;
	
	public AuthenticationRequest() {}

	public AuthenticationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
//		this.setEmail(email);
//		this.setPhonenumber(phonenumber);
	}

//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhonenumber() {
//		return phonenumber;
//	}
//
//	public void setPhonenumber(String phonenumber) {
//		this.phonenumber = phonenumber;
//	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
