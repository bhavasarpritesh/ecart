package com.bbd.pritesh.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.bbd.pritesh.service.impl.UserDetailsImpl;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtTokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .setIssuer("ecart")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(60)))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getEmailFromJwtToken(String token) {
       
    	return getClaims(token).getSubject();   
    	}
 
  	private boolean isTokenExpired(String token) {
  		final Date expiration = getExpDate(token);
  		return expiration.before(new Date());
  	}
    
    
    private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody();
	}
    public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
    public boolean validateJwtToken(String token) {
    	//String usernameInToken = getEmailFromJwtToken(token);
		return ( !isTokenExpired(token));
    }
}
