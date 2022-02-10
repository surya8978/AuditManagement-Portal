package com.audit.severityauditmanagement.services;

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

import com.audit.severityauditmanagement.feignclient.AuthClient;
import com.audit.severityauditmanagement.feignclient.AuthResponse;


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
	ResponseEntity<AuthResponse> authResponseentity;
	
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {
		authResponseentity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true),HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(authResponseentity);
        assertEquals(true, tokenService.checkTokenValidity("token"));
	}
	

	
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		authResponseentity = new ResponseEntity<AuthResponse>(new AuthResponse(null,false),HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(authResponseentity);
		assertEquals(false, tokenService.checkTokenValidity("token"));
	}
	@Test
	public void testCheckTokenValidityWhenTokenIsnull() {

		when(authClient.getValidity(null)).thenReturn(authResponseentity);

		assertEquals(false, tokenService.checkTokenValidity(null));

	}
}
