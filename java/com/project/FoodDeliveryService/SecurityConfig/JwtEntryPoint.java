package com.project.FoodDeliveryService.SecurityConfig;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.io.IOException;
//import java.io.Serializable;
//import javax.naming.AuthenticationException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//@Component
//public class JwtEntryPoint implements AuthenticationEntryPoint {
//
//	private static final Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
//	
//	public void commence(HttpServletRequest request
//			, HttpServletResponse response,
//			org.springframework.security.core.AuthenticationException authException) throws IOException, 
//	         ServletException {
//		logger.error("Unauthorized error: {}", authException.getMessage());
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
//	}
//
//	
//}


import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}

