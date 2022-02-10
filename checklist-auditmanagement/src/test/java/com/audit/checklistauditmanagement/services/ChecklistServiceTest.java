package com.audit.checklistauditmanagement.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.checklistauditmanagement.exceptions.AuditTypeException;
import com.audit.checklistauditmanagement.model.AuditQuestions;
import com.audit.checklistauditmanagement.repository.ChecklistRepository;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class ChecklistServiceTest {

	@Mock
	ChecklistRepository questionsRespository;

	@InjectMocks
	ChecklistService questionsService;

	@Test
	public void testGetQuestionsList() throws AuditTypeException {

		List<AuditQuestions> questions = new ArrayList<>();
		questions.add(new AuditQuestions(1, "Internal", "Have all Change requests followed SDLC before PROD move?"));
		when(questionsRespository.findByAuditType("Internal")).thenReturn(questions);
		assertEquals(questions, questionsService.getQuestions("Internal"));

	}
	
@Test 
    public void throwsExceptionWheninvalidaudittype() throws AuditTypeException {
	List<AuditQuestions> questions = new ArrayList<>();
	questions.add(new AuditQuestions(1, "Internal", "Have all Change requests followed SDLC before PROD move?"));
	   assertNull(questionsService.getQuestions("ss")) ;
    }

}
