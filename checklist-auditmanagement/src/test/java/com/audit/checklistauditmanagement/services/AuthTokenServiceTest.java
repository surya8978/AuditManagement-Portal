package com.audit.checklistauditmanagement.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.checklistauditmanagement.feignclient.AuthClient;
import com.audit.checklistauditmanagement.feignclient.AuthResponse;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuthTokenServiceTest {

	@InjectMocks
	AuthTokenService tokenService;
	@Mock
	AuthClient authClient;

	@Mock
	AuthResponse authResponse;

	@Mock
	ResponseEntity<AuthResponse> entity;


	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {

		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true), HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(entity);

		assertEquals(true, tokenService.checkTokenValidity("token"));

	}

	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		
		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, false), HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(entity);
		assertEquals(false, tokenService.checkTokenValidity("token"));

	}
	
	@Test
	public void testCheckTokenValidityWhenTokenIsnull() {

		when(authClient.getValidity(null)).thenReturn(entity);

		assertEquals(false, tokenService.checkTokenValidity(null));

	}
	
}
