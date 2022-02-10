package com.audit.jwtauditmanagement.model;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import com.audit.jwtauditmanagement.model.AuditManager;
import com.audit.jwtauditmanagement.repository.ManagerRepo;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ManagerServiceTest {

UserDetails userdetails;
	
	@InjectMocks
	ManagerService managerdetailservice;

	@Mock
	ManagerRepo userservice;

	@Test
	public void loadUserByUsernameTest() {
		AuditManager user1=new AuditManager("audit1","password1",null,9000);
		Optional<AuditManager> data =Optional.of(user1) ;
		when(userservice.findById("audit1")).thenReturn(data);
		UserDetails loadUserByUsername2 = managerdetailservice.loadUserByUsername("audit1");
		assertEquals(user1.getUserId(),loadUserByUsername2.getUsername());
	}
	
	@Test
	public void loadUserByUsernameExceptionTest() throws UsernameNotFoundException {
		AuditManager user1=new AuditManager("audit1","password1",null,9000);
		Optional.of(user1) ;
		UsernameNotFoundException thrown = Assertions.assertThrows(UsernameNotFoundException.class, () -> {
			managerdetailservice.loadUserByUsername("test");
	    });
		Assertions.assertEquals("User Not Found with username test", thrown.getMessage());
	}

}

