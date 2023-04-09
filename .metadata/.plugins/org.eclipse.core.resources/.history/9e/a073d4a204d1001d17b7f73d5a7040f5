package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.jwt.JwtUtils;
import com.example.domain.User;
import com.example.model.JwtResponse;
import com.example.model.LoginRequest;
import com.example.model.UserDetailsImpl;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired 
	AuthenticationManager authenticationManager;
	
	@Autowired UserService userService;
	
	@Autowired JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);	
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails =(UserDetailsImpl)authentication.getPrincipal();	
		List<String> roles = userDetails.getAuthorities().stream()
				.map(e -> e.getAuthority()).collect(Collectors.toList());
		
		System.out.println(userDetails.getEmail());
		
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
													userDetails.getEmail(), roles));
		
	}
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody User user) {
		System.out.println("Got it from signup controller");
		userService.save(user);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/getUserEmail/{username}")
	public String getUserById(@PathVariable String username) {
		System.out.println("Got it from getUser controller");
		return userService.findByUserName(username).getEmail();
//		return null;
	}

}
