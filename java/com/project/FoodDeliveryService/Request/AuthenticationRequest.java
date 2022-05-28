package com.project.FoodDeliveryService.Request;


public class AuthenticationRequest
{

	private static final long serialVersionUID = 5926468583005150707L;

	
	private String password;

	private String phonenumber;
	
	public AuthenticationRequest() {}

	public AuthenticationRequest(String phonenumber, String password) {

		this.setPassword(password);

		this.setPhonenumber(phonenumber);
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
