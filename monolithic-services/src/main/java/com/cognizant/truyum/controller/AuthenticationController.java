package com.cognizant.truyum.controller;

import java.util.Base64;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class AuthenticationController {

	
	@GetMapping(value = "/authenticate")
	public void authenticate(@RequestHeader("Authorization") String authHeader) {
		System.out.println(authHeader);
		String user = getUser(authHeader);
		System.out.println(user);
		String token = generateJwt(user);
		System.out.println(token);
	}
	 
	private String getUser(String authHeader) {
		 String encoded = authHeader.substring(6).toString();
		 System.out.println(encoded);
		 Base64.Decoder decoder = Base64.getMimeDecoder();  
		 String decoded = new String(decoder.decode(encoded)); 
		 return decoded;
	 }
	 
	 private String generateJwt(String user) {
		 
		    JwtBuilder builder = Jwts.builder();
	        builder.setSubject(user);

	        // Set the token issue time as current time
	        builder.setIssuedAt(new Date());

	        // Set the token expiry as 20 minutes from now
	        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
	        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

	        String token = builder.compact();
	        
	        return token;
		
	 }
}
