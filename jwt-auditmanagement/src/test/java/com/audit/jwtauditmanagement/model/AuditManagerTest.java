package com.audit.jwtauditmanagement.model;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuditManagerTest {

	AuditManager auditManager = new AuditManager();

	@Test
	public void testProjectManagerAllConstructor() {
		AuditManager manager = new AuditManager("audit1", "password1", null,90000);
		assertEquals("audit1", manager.getUserId());
		
	}

	@Test
	public void testUserid() {
		
		auditManager.setUserId("audit1");
		assertEquals("audit1", auditManager.getUserId());
		
	}

	@Test
	public void testUserPassword() {
		auditManager.setPassword("audit1");
		assertEquals("audit1", auditManager.getPassword());
	}

	@Test
	public void testAuthToken() {
		auditManager.setAuthToken("audit1");
		assertEquals("audit1", auditManager.getAuthToken());
	}
	@Test
	public void testExpiration() {
		auditManager.setJwtExpirationMs(90000);
		assertEquals(90000, auditManager.getJwtExpirationMs());
	}

	@Test
	public void testoString() {
		String string = auditManager.toString();
		assertEquals(string, auditManager.toString());
	}

}

