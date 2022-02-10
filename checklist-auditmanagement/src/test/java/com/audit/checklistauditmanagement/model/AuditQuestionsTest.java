package com.audit.checklistauditmanagement.model;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuditQuestionsTest {
	
	AuditQuestions questions=new AuditQuestions();
	
	
	@Test
	public void testParameterizedConstructor() {
		AuditQuestions questions=new AuditQuestions(1,"Other","Have all changes has been approved");
	    assertEquals("Other",questions.getAuditType());
	}
	
	@Test
	public void testQuestionId() {
		questions.setQuestionId(2);
		assertEquals(2,questions.getQuestionId());
	}
	
	@Test
	public void testQuestionType() {
		questions.setAuditType("Internal");
		assertEquals("Internal",questions.getAuditType());
	}
	
	@Test
	public void testQuestion() {
		questions.setQuestions("Do you have any changes?");
		assertEquals("Do you have any changes?",questions.getQuestions());
	}
}