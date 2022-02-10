package com.audit.checklistauditmanagement.exceptions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@ContextConfiguration

public class CustomErrorResponseTest {
	

	@Test
	public void testCustomErrorResponse() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		assertNotNull(customErrorResponse);
	}

	
	@Test
	public void testCustomErrorResponseParameterized() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK, "Message",
				"reason");
		assertNotNull(customErrorResponse);

	}

	
	@Test
	public void testToStringMethod() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK, "Message",
				"reason");
		assertEquals(customErrorResponse.toString(), customErrorResponse.toString());

	}

	@Test
	public void testGetStatus() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK, customErrorResponse.getStatus());

	}

	

	@Test
	public void testGetMessage() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");
		assertEquals("Message", customErrorResponse.getMessage());

	}

	
	@Test
	public void testSetLocalDateTime() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setTimestamp(LocalDateTime.now());

	}

	@Test
	public void testSetStatus() {

		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.OK);

	}

	@Test
	public void testSetMessage() {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setMessage("Message");

	}

}

