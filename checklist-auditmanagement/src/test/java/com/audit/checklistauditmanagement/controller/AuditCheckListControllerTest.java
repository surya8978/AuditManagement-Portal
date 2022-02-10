package com.audit.checklistauditmanagement.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.checklistauditmanagement.exceptions.AuditTypeException;
import com.audit.checklistauditmanagement.feignclient.AuthClient;
import com.audit.checklistauditmanagement.model.AuditQuestions;
import com.audit.checklistauditmanagement.repository.ChecklistRepository;
import com.audit.checklistauditmanagement.services.AuthTokenService;
import com.audit.checklistauditmanagement.services.ChecklistService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuditCheckListControllerTest {

	@Mock
	AuthClient authClient;

	@Mock
	AuthTokenService tokenService;


	@Mock
	ChecklistService questionsService;

	@Mock
	Environment env;

	@InjectMocks
	AuditChecklistController auditCheckListController;

	@Mock
	ChecklistRepository questionsRepository;

	@Test
	public void contextLoads() {
		assertNotNull(auditCheckListController);
	}

	@Test
	public void testGetChecklist() throws AuditTypeException {
		ResponseEntity<?> responseEntity = null;
		List<AuditQuestions> questionsList = new ArrayList<AuditQuestions>();
		questionsList.add(new AuditQuestions(1, "Internal", "How are you"));
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		when(questionsService.getQuestions("Internal")).thenReturn(questionsList);
		responseEntity = auditCheckListController.getQuestions("token", "Internal");
		assertNotNull(responseEntity);
	}

	@Test
	public void testGetChecklistTokenInvalid() {
		ResponseEntity<?> responseEntity = null;
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		responseEntity = auditCheckListController.getQuestions("token", "Internal");
		assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
	}
	
	@Test
	public void testGetChecklistException() throws AuditTypeException {
		ResponseEntity<?> responseEntity = null;
		List<AuditQuestions> questionsList = new ArrayList<AuditQuestions>();
		questionsList.add(new AuditQuestions(1, "Internal", "How are you"));
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		when(questionsService.getQuestions("Inter")).thenThrow(AuditTypeException.class);
		responseEntity = auditCheckListController.getQuestions("token", "Inter");
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}



}

