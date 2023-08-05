package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.JwtAuthRequest;
import com.blog.payload.JwtAuthResponse;
import com.blog.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request){
			this.authenticate(request.getUsername(),request.getPassword()) ;
			
			UserDetails details = this.userDetailsService.loadUserByUsername(request.getUsername());
			 String generateToken =this.jwtTokenHelper.generateToken(details);
			 JwtAuthResponse response = new JwtAuthResponse();
			 response.setToken(generateToken);
			 return new ResponseEntity<JwtAuthResponse> (response,HttpStatus.OK);
	}

	private void authenticate(String username, String password) {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(username,password);
		
		this.authenticationmanager.authenticate(upat);
		
	}
}
