package com.audit.checklistauditmanagement.exceptions;

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
	ErrorHandler handler;

	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}

	@Test
	public void testhandelWrongDateFormateException() {
		assertNotNull(handler.handelFeignProxyException(new FeignProxyException()));
	}

}
