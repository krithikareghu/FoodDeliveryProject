package com.project.FoodDeliveryService.Model;

import org.springframework.lang.NonNull;

public class RefreshTokenRquest {
	@NonNull
	  private String refreshToken;
	  public String getRefreshToken() {
	    return refreshToken;
	  }
	  public void setRefreshToken(String refreshToken) {
	    this.refreshToken = refreshToken;
	  }
	}


