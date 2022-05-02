package com.project.FoodDeliveryService.SecurityConfig;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.FoodDeliveryService.Service.CustomUserDetailService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtils;
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;

		if ((requestTokenHeader != null ))//&&( requestTokenHeader.startsWith("Bearer "))) 
				{
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				username = jwtUtils.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
			
		} else {
			logger.warn("Token Header is null");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);
			
			if (jwtUtils.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null,null); //userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}
}





















//
//
//
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		try {
//			String jwt = parseJwt(request);
//			
//			if (jwt != null && jwtUtils.validateToken(jwt, null)) {
//				String username = jwtUtils.getUsernameFromToken(jwt);
//				
//				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//					UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);
//
//					if (jwtUtils.validateToken(jwt, userDetails)) {
//
//						UsernamePasswordAuthenticationToken authentication = 
//								new UsernamePasswordAuthenticationToken
//								(userDetails, null, userDetails.getAuthorities());
//						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//						SecurityContextHolder.getContext().setAuthentication(authentication);
//					}
//				}
//			}
//		} catch (Exception e) {
//			logger.error("Cannot set user authentication: {}", e);
//		}
//		filterChain.doFilter(request, response);
//	}
//
//	private String parseJwt(HttpServletRequest request) {
//		final String autherizationHeader = request.getHeader("Authorization");
//		if (autherizationHeader!=null && autherizationHeader.startsWith("Bearer ")) {
//			return autherizationHeader.substring(7, autherizationHeader.length());
//		}
//		return null;
//	}
//}