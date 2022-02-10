package com.audit.jwtauditmanagement.exceptions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ErrorHandlerTest {

	@InjectMocks
	ErrorHandler handler;

	@Mock
	Environment env;

	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}

	@Test
	public void testhandelWrongDateFormateException() {
		
		assertNotNull(handler.handleIdNotFoundexception(new LoginException()));
		
	}

	@Test
	public void testhandelWrongDateFormateExceptionThrowable() {
		
		assertNotNull(handler.handleIdNotFoundexception(new LoginException(new Throwable())));
		
	}

	@Test
	public void testhandelWrongDateFormateExceptionmsg() {
	
		assertNotNull(handler.handleIdNotFoundexception(new LoginException("message")));
		
	}

	@Test
	public void testhandelWrongDateFormateExceptionmsgThrowable() {
		
		assertNotNull(handler.handleIdNotFoundexception(new LoginException("msg", new Throwable())));
		
	}
	@Test
	public void testhandelTokenExceptionmsgThrowable() {
		
		assertNotNull(handler.handleTokenNotFoundexception(new TokenException("msg")));
		
	}
	@Test
	public void testhandelUserExceptionmsgThrowable() {
		
		assertNotNull(handler.handleUserNotFoundexception(new UsernameNotFoundException("msg")));
		
	}
	
}
