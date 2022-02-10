package com.audit.severityauditmanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.audit.severityauditmanagement.feignclient.AuthClient;
import com.audit.severityauditmanagement.model.AuditDetails;
import com.audit.severityauditmanagement.model.AuditRequestDetails;

import com.audit.severityauditmanagement.services.RequestResponseService;
import com.audit.severityauditmanagement.services.AuthTokenServiceInt;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuditSeverityControllerTest {

	@Mock
	private RequestResponseService service;

	@Mock
	AuthClient authClient;


	@Mock
	AuditRequestDetails auditRequest;

	@Mock
	AuthTokenServiceInt tokenService;

	@InjectMocks
	AuditSeverityController severityController;

	@Test
	public void contextLoad() {
		assertNotNull(severityController);
	}

	@Test
	public void testExecutionStatus1() {
		
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		AuditRequestDetails request = new AuditRequestDetails();
		request.setManagerName("manager");
		request.setOwnerName("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(new Date());
		details.setAuditType("Internal");
		details.setQuestionResponse(2);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.OK, severityController.getExceutionStatus("token", request).getStatusCode());
	}

	@Test
	public void testExecutionStatus2() {
		
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		AuditRequestDetails request = new AuditRequestDetails();
		request.setManagerName("manager");
		request.setOwnerName("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(new Date());
		details.setAuditType("Internal");
		details.setQuestionResponse(4);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.OK, severityController.getExceutionStatus("token", request).getStatusCode());
	}
	
	@Test
	public void testExecutionStatus3() {
		
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		AuditRequestDetails request = new AuditRequestDetails();
		request.setManagerName("manager");
		request.setOwnerName("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(new Date());
		details.setAuditType("Other");
		details.setQuestionResponse(2);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.OK, severityController.getExceutionStatus("token", request).getStatusCode());
	}
	
	@Test
	public void testExecutionStatus4() {
		
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		AuditRequestDetails request = new AuditRequestDetails();
		request.setManagerName("manager");
		request.setOwnerName("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(new Date());
		details.setAuditType("Other");
		details.setQuestionResponse(4);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.OK, severityController.getExceutionStatus("token", request).getStatusCode());
	}
	
	@Test
	public void testAuditSeverityTokenFails() {
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		AuditRequestDetails request = new AuditRequestDetails();
		request.setManagerName("manager");
		request.setOwnerName("owner");
		request.setProjectName("project");
		AuditDetails details = new AuditDetails();
		details.setAuditDate(new Date());
		details.setAuditType("Other");
		details.setQuestionResponse(4);
		request.setAuditDetails(details);
		assertEquals(HttpStatus.FORBIDDEN, severityController.getExceutionStatus("token", request).getStatusCode());
	}

}
