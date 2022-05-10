package com.project.FoodDeliveryService.dto;

public class ItemDataDto {
	
	private String itemname;
	private String itempicture;
	

	public String getItempicture() {
		return itempicture;
	}


	public void setItempicture(String itempicture) {
		this.itempicture = itempicture;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname,String itempicture ) {
		
		this.itemname = itemname;
		this.itempicture=itempicture;
	}

	

}
