package com.project.FoodDeliveryService.SecurityConfig;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil implements Serializable{
	private String Secret_key="secret";
	private static final long serialVersionUID = -2550185165626007488L;
	//public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//	@Value("${jwt.secret}")
//	private String secret;

	public String generateToken(UserDetails userDetails)
	{
		Map<String, Object>claims=new HashMap<>();
		return createtoken(claims,userDetails.getUsername());
	}
	
	private String createtoken(Map<String, Object> claims,String subject)
	{
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date (System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
				.signWith(SignatureAlgorithm.HS512,Secret_key).compact();	
	}
	
	public boolean validateToken(String token,UserDetails userDetails) {
		final String username=getUsernameFromToken(token);
		return(username.equals(userDetails.getUsername())&&!isTokenExpired(token));
	}
	private boolean isTokenExpired(String token) {
		return getExpirationDateFromToken(token).before(new Date());
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(Secret_key).parseClaimsJws(token).getBody();
	}
	
}




//private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//	return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//			.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//			.signWith(SignatureAlgorithm.HS512, secret).compact();
//}
//private Date extractExpiration(String token) {
//	return getClaimFromToken(token,claims::getExpiration);
//}

//	//check if the token has expired
//	private boolean istokenexpired(string token) {
//		final date expiration = getexpirationdatefromtoken(token);
//		return expiration.before(new date());
//	}

//	public<T,T>extractclaim(String token,FunctionalInterface<claims,T>claimsResolver)
//	{
//		final Claims claims = getAllClaimsFromToken(token);
//		return claimsResolver.apply(claims);
//	}
//	//generate token for user
//	public String generateToken(UserDetails userDetails) {
//		Map<String, Object> claims = new HashMap<>();
//		return doGenerateToken(claims, userDetails.getUsername());
//	}


	


	//validate token
//	public Boolean validateToken(String token, UserDetails userDetails) {
//		final String username = getUsernameFromToken(token);
//		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	}
