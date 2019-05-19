package com.example.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private String expiration;

	public String generateToken(String username) {
		Date exp = new Date();
		exp.setTime(System.currentTimeMillis() + Long.parseLong(expiration));

		return Jwts.builder().setSubject(username).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}
}
