package com.project.FoodDeliveryService.dto;

import javax.persistence.Column;

public class RoleDto {

	private String phonenumber;
	private String rolename;

	public String getRolename() {
		return rolename;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	


	
}
