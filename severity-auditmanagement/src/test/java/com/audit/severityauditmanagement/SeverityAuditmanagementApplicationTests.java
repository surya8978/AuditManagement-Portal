package com.audit.severityauditmanagement;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class SeverityAuditmanagementApplicationTests {

	@Mock
	SeverityAuditmanagementApplication severityAuditmanagementApplication=new SeverityAuditmanagementApplication();
	
	@Test
	public void contextLoads() {
		assertNotNull(severityAuditmanagementApplication);
	}

}
