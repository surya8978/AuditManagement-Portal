package com.audit.checklistauditmanagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class ChecklistAuditmanagementApplicationTests {

	

	@Mock
	ChecklistAuditmanagementApplication checklistAuditmanagementApplication=new ChecklistAuditmanagementApplication();
	
	@Test
	public void contextLoads() {
		assertNotNull(checklistAuditmanagementApplication);
	}
}
