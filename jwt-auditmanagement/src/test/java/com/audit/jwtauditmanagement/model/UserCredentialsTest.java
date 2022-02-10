package com.audit.jwtauditmanagement.model;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class UserCredentialsTest {

	UserCredentials loginCredential = new UserCredentials();

	@Test
	public void testUserLoginCredentialAllConstructor() {
		UserCredentials credential = new UserCredentials("audit1", "password1");
		assertEquals(credential.getUserId(), "audit1");
	}

	@Test
	public void testGetUid() {
		loginCredential.setUserId("audit1");
		assertEquals(loginCredential.getUserId(), "audit1");
	}

	@Test
	public void testUserPassword() {
		loginCredential.setPassword("audit1");
		assertEquals(loginCredential.getPassword(), "audit1");
	}

	@Test
	public void testoString() {
		String string = loginCredential.toString();
		assertEquals(loginCredential.toString(), string);
	}

}

