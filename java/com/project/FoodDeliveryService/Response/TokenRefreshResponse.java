package com.project.FoodDeliveryService.Response;

import com.project.FoodDeliveryService.Model.UserData;

public class TokenRefreshResponse {
	
	 private String accessToken;
	  private String refreshToken;
	  private String tokenType = "Bearer";
	  private UserData userData;


	  public TokenRefreshResponse(String accessToken, String refreshToken,UserData user) {
	    this.accessToken = accessToken;
	    this.refreshToken = refreshToken;
	    this.userData=user;
	  }

	  public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	public String getAccessToken() {
	    return accessToken;
	  }

	  public void setAccessToken(String token) {
	    this.accessToken = token;
	  }

	  public String getRefreshToken() {
	    return refreshToken;
	  }

	  public void setRefreshToken(String refreshToken) {
	    this.refreshToken = refreshToken;
	  }

	  public String getTokenType() {
	    return tokenType;
	  }

	  public void setTokenType(String tokenType) {
	    this.tokenType = tokenType;
	  }


}
