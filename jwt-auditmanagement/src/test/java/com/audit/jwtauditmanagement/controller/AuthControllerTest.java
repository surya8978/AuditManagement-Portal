package com.audit.jwtauditmanagement.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.jwtauditmanagement.exceptions.LoginException;
import com.audit.jwtauditmanagement.model.AuthResponse;
import com.audit.jwtauditmanagement.model.AuditManager;
import com.audit.jwtauditmanagement.model.UserCredentials;
import com.audit.jwtauditmanagement.repository.ManagerRepo;
import com.audit.jwtauditmanagement.security.JwtUtil;
import com.audit.jwtauditmanagement.model.ManagerService;


@ExtendWith(SpringExtension.class)
public class AuthControllerTest { 

	@InjectMocks
	AuthController authController;

	AuthResponse authResponse;

	UserDetails userdetails;

	@Mock
	JwtUtil jwtutil;

	@Mock
	ManagerService managerdetailservice;

	@Mock
	ManagerRepo managerservice;
	
	@Test
	public void loginTest() throws Exception {
		
		UserCredentials user = new UserCredentials("admin", "admin");
		
		UserDetails loadUserByUsername = managerdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserId(), user.getPassword(), new ArrayList<>());
		
		when(managerdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		
		ResponseEntity<?> login =authController.login(user);;
		assertEquals( 200 , login.getStatusCodeValue() );
	}

	@Test
	public void invalidLoginTest() throws LoginException, Exception {
		UserCredentials user = new UserCredentials("admin", "admin");
		UserDetails loadUserByUsername = managerdetailservice.loadUserByUsername("admin");
		UserDetails value = new User(user.getUserId(), "admin11", new ArrayList<>());
		when(managerdetailservice.loadUserByUsername("admin")).thenReturn(value);
		when(jwtutil.generateToken(loadUserByUsername)).thenReturn("token");
		Assertions.assertThrows(Exception.class, () -> {
		when(authController.login(user)).thenThrow(new LoginException());
		});
	}

	
	  @Test
	  public void validateTestValidtoken() {
	  when(jwtutil.validateToken("token")).thenReturn(true);
	  when(jwtutil.extractUsername("token")).thenReturn("admin");
	  AuditManager user1 = new AuditManager("admin", "admin", "admin",900000);
	  Optional<AuditManager> data = Optional.of(user1);
	  when(managerservice.findById("admin")).thenReturn(data); 
	  ResponseEntity<?> validity = authController.getValidity("Bearer token");
	  assertEquals(true , validity.getBody().toString().contains("true"));
	  }
	 

	@Test
	public void validateTestInValidtoken() {
		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = authController.getValidity("Bearer token");
		assertEquals( true ,  validity.getBody().toString().contains("false") );
		
	}
	
	
}

