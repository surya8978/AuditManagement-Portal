package com.audit.severityauditmanagement.model;


import static org.junit.Assert.assertEquals;

import java.util.Date;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
public class AuditDetailsTest {

	private AuditDetails auditDetails;
	
	
	@BeforeEach
	public void setup() {
		auditDetails = new AuditDetails();
	}
	
	@Test
	public void testAuditDetailsAllConstructor() {
		AuditDetails auditDetails = new AuditDetails(2, "Internal", null,4);
		assertEquals(2,auditDetails.getAuditId());
		
	}
	
	@Test
	public void testGetSetquestionResponse() {
		auditDetails.setQuestionResponse(4);
		assertEquals(4, (int)auditDetails.getQuestionResponse());
	}
	
	
	@Test
	public void testGetSetAuditDate() {
		Date date = new Date();
		auditDetails.setAuditDate(date);
		assertEquals(date, auditDetails.getAuditDate());
	}
	
	@Test
	public void testGetSetAuditType() {
		auditDetails.setAuditType("Internal");
		assertEquals("Internal", auditDetails.getAuditType());
	}
	
	@Test
	public void testGetAuditId() {
		auditDetails.setAuditId(5);
		assertEquals(5, auditDetails.getAuditId());
	}
}
