package org.serratec.bakcend.servicedto.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${auth-jwt-secret}")
	private String jwtSecret;
	@Value("${auth-jwt-expiration-mileseg}")
	private Long jwtExpirationMiliseg;

	public String generateTokem(String username) {
		SecretKey secretketSpec = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		return Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + this.jwtExpirationMiliseg))
				.signWith(secretketSpec)
				.compact();
	}
	
	public boolean isValidToken(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}
	
	public String getUserName(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}
	
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(jwtSecret.getBytes())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

}
