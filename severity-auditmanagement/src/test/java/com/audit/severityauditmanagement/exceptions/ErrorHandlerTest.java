package com.audit.severityauditmanagement.exceptions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ErrorHandlerTest {

	@InjectMocks
	ErrorHandler globalExceptionHandler;
	
	
    @Test
	public void contextLoads() {
		assertNotNull(globalExceptionHandler);
	}
	
	@Test
	public void testhandelWrongDateFormateException() {
		assertNotNull(globalExceptionHandler.handelFeignProxyException(new FeignProxyException()));
	}
	
}
