package com.audit.severityauditmanagement.exceptions;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class FeignProxyExceptionTest {

	
	@Test
	public void testInvalidAuthorizationException() {
		FeignProxyException feignException = new FeignProxyException();
		assertNotNull(feignException);
	}
}
