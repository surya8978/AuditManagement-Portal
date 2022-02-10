package com.audit.severityauditmanagement.exceptions;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration 
public class TokenExceptionTest {

	@Mock
	TokenException tokenException;
	
	
	@Test
	public void contextLoads() {
		assertNotNull(tokenException);
	}
	
	@Test 
	public void testConstructor() {
		assertNotNull(new TokenException("Exception"));
	}

}
