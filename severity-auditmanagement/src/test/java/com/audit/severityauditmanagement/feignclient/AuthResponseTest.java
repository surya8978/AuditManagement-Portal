package com.audit.severityauditmanagement.feignclient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class AuthResponseTest {

	private AuthResponse authResponse;
	
	@BeforeEach
	public void setup() {
		authResponse = new AuthResponse();
	}
	
	
	@Test
	public void testGetSetUid() {
		authResponse.setUid("uid");
		assertEquals("uid", authResponse.getUid());
	}
	
	
	@Test
	public void testValid() {
		authResponse.setValid(false);
		assertFalse(authResponse.isValid());
	}
	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
    }
}
