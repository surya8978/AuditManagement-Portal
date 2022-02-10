package com.audit.severityauditmanagement.model;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AuditResponseDetailsTest {

	private AuditResponseDetails auditResponse;

	
	@BeforeEach
	public void setup() {
		auditResponse = new AuditResponseDetails();
	}

	
	@Test
	public void testGetSetProjectExecutionStatus() {
		auditResponse.setExecutionStatus("GREEN");
		assertEquals("GREEN", auditResponse.getExecutionStatus());
	}

	
	@Test
	public void testGetSetRemedialActionDuration() {
		auditResponse.setDuration("None");
		assertEquals("None", auditResponse.getDuration());
	}

	@Test
	public void testGetResponseId() {
		auditResponse.setResponseId(5);
		assertEquals(5, auditResponse.getResponseId());
	}

	@Test
	public void testGetSetAuditType() {
		auditResponse.setAuditType("Internal");
		assertEquals("Internal", auditResponse.getAuditType());
	}

	@Test
	public void testSetGetAuditType() {
		auditResponse.setAuditType("Internal");
		assertEquals("Internal", auditResponse.getAuditType());
	}

	@Test
	public void testSetGetAuditDate() {
		auditResponse.setAuditDate(null);
		assertEquals(null, auditResponse.getAuditDate());
	}

	@Test
	public void testSetGetManagerName() {
		auditResponse.setManagerName("manager");
		assertEquals("manager", auditResponse.getManagerName());
	}

	@Test
	public void testSetGetProjectName() {
		auditResponse.setProjectName("audit");
		assertEquals("audit", auditResponse.getProjectName());
	}

	@Test
	public void testSetGetOwnerName() {
		auditResponse.setOwnerName("owner");
		assertEquals("owner", auditResponse.getOwnerName());
	}

}
