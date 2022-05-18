package com.project.FoodDeliveryService.SecurityConfig;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
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

		if ((requestTokenHeader != null )&&( requestTokenHeader.startsWith("Bearer "))) 
				{
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				
				username = jwtUtils.getUsernameFromToken(jwtToken);
				}catch (ExpiredJwtException ex) {

					String isRefreshToken = request.getHeader("isRefreshToken");
					String requestURL = request.getRequestURL().toString();
					// allow for Refresh Token creation if following conditions are true.
					if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken")) {
						allowForRefreshToken(ex, request);
					} else
						request.setAttribute("exception", ex);

				} catch (BadCredentialsException ex) {
					request.setAttribute("exception", ex);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			
		} else {
			logger.warn("Token Header is null");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);
			
			if (jwtUtils.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}
	private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {

		// create a UsernamePasswordAuthenticationToken with null values.
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				null, null, null);
		// After setting the Authentication in the context, we specify
		// that the current user is authenticated. So it passes the
		// Spring Security Configurations successfully.
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		// Set the claims so that in controller we will be using it to create
		// new JWT
		request.setAttribute("claims", ex.getClaims());

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