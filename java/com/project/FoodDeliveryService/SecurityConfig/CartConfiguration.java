package com.project.FoodDeliveryService.SecurityConfig;

import java.util.HashMap;

import com.project.FoodDeliveryService.Model.UserData;

public class CartConfiguration {
	public static Boolean validationWithHashMap(String keys[],HashMap<String,String> request) throws Exception{
		Boolean status = false;
		try {
			for(int start = 0;start<keys.length;start++) {
				
				if(request.containsKey(keys[start])) {//not exist
					if(request.get(keys[start]).equals("")){//if empty
						throw new Exception(keys[start]+" Should not be empty");
					}
				}else {
					throw new Exception(keys[start]+" is missing");
				}
			}
		}catch(Exception e) {
			throw new Exception("Error is "+e.getMessage());
		}
		return status;
	}

}
