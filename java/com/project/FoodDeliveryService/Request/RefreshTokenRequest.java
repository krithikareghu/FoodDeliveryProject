package com.project.FoodDeliveryService.Request;

import org.springframework.lang.NonNull;

public class RefreshTokenRequest {
	@NonNull
	  private String refreshToken;
	  public String getRefreshToken() {
	    return refreshToken;
	  }
	  public void setRefreshToken(String refreshToken) {
	    this.refreshToken = refreshToken;
	  }
	}


