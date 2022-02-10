package com.audit.severityauditmanagement.model;
import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class AuditRequestDetailsTest {

	private AuditRequestDetails auditRequest;
	
	@BeforeEach
	public void setup() {
		auditRequest = new AuditRequestDetails();
	}
	
	@Test
	public void testAuditRequestDetailsAllConstructor() {
		AuditRequestDetails auditRequestDetails = new AuditRequestDetails(2, null, "sss","sss","sss");
		assertEquals(2,auditRequestDetails.getRequestId());
		
	}
	
	@Test
	public void testSetGetAuditDetails() {
		AuditDetails auditDetails = new AuditDetails(2, "Internal", null,4);
		auditRequest.setAuditDetails(auditDetails);
		assertEquals(auditDetails, auditRequest.getAuditDetails());
	}
	
	@Test
	public void testSetGetRequestId() {
		auditRequest.setRequestId(2);
		assertEquals(2, auditRequest.getRequestId());
	}
	
	@Test
	public void testGetSetProjectName() {
		auditRequest.setProjectName("Name1");
		assertEquals("Name1", auditRequest.getProjectName());
	}
	
	@Test
	public void testGetSetProjectManagerName() {
		auditRequest.setManagerName("Name2");
		assertEquals("Name2", auditRequest.getManagerName());
	}
	
	@Test
	public void testGetSetOwnerName() {
		auditRequest.setOwnerName("Name3");
		assertEquals("Name3", auditRequest.getOwnerName());
	}
	
	
}
