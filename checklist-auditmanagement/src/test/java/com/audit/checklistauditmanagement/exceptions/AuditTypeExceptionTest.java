package com.audit.checklistauditmanagement.exceptions;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class AuditTypeExceptionTest {

	@Mock
	AuditTypeException auditTypeException;
	
	@Test
	public void contextLoads() {
		assertNotNull(auditTypeException);
	}
	
	@Test 
	public void testConstructor() {
		
		assertNotNull(new AuditTypeException("message"));
	}
}
