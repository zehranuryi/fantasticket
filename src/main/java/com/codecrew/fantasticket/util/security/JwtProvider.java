package com.codecrew.fantasticket.util.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
	String generateToken(CustomUserDetails user);
	
	Authentication getAuthenticationObject(HttpServletRequest request);
	
	boolean isTokenValid(HttpServletRequest request);
	
	Claims extractClaimsFromToken(HttpServletRequest request);
}