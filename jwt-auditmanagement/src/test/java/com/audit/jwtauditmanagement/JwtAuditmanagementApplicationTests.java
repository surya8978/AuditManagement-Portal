package com.audit.jwtauditmanagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import com.audit.jwtauditmanagement.JwtAuditmanagementApplication;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JwtAuditmanagementApplicationTests {

	@Mock
	JwtAuditmanagementApplication jwtAuditmanagementApplication=new JwtAuditmanagementApplication();

	@Test
	void contextLoads() {
		assertNotNull(jwtAuditmanagementApplication);
	}

}
