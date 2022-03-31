//package com.project.FoodDeliveryService.JWT;
//import java.security.Signature;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.security.core.userdetails.UserDetails;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class JwtUtil {
//	private String Secret_key="secret";
//	
//	public String extractUsername(String token) {
//		return extractclaim(token,claim::getSubject);
//	}
//	public String generateToken(UserDetails userDetails)
//	{
//		Map<String, Object>claimsMap=new HashMap<>();
//		return createToken(claims,userDetails.getUsername());
//	}
//	private String createtoken(Map<String, Object> claims,String subject)
//	{
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date (System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis()+1000+60+10)).signWith(SignatureAlgorithm.HS256,Secret_key).compact();	
//	}
//	public boolean validateToken(String token,UserDetails userDetails) {
//		final String usernameString=extractUsername(token);
//		return(usernameString.equals(userDetails.getUsername())&&!isTokenExpired(token));
//	}
//	private boolean isTokenExpired(String token) {
//		return extractExpiration(token).before(new Date());
//	}
//	private Date extractExpiration(String token) {
//		return extractClaim(token,claims::getExpiration);
//	}
//	public<T,T>extractclaim(String token,FunctionalInterface<claims,T>claimsResolver)
//	{
//		final Claims claims = getAllClaimsFromToken(token);
//		return claimsResolver.apply(claims);
//	}
//
//}
