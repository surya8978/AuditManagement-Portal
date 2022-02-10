package com.audit.severityauditmanagement.services;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.audit.severityauditmanagement.model.AuditRequestDetails;
import com.audit.severityauditmanagement.model.AuditResponseDetails;
import com.audit.severityauditmanagement.repository.RequestRepository;
import com.audit.severityauditmanagement.repository.ResponseRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class RequestResponseServiceTest {

	@InjectMocks
	RequestResponseService requestResponseService;

	@Mock
	RequestResponseService req1;

	@Mock
	ResponseRepository responseRepository;
    
	@Mock
	RequestRepository requestRepository;
	
	
	@Test
	public void saveResponseTest() {
		Date auditDate = new Date();
		AuditResponseDetails response = new AuditResponseDetails(1, "GREEN", "No action required", " projectName", "managerName",
				"ownerName", "auditType2", auditDate);
		AuditResponseDetails response1 = response;
		when(responseRepository.save(response1)).thenReturn(response1);
		assertEquals(response1, requestResponseService.saveResponse(response));

	}
	@Test
	public void saveRequestTest() {
		AuditRequestDetails response = new AuditRequestDetails(1, null, " projectName", "managerName",
				"ownerName");
		AuditRequestDetails response1 = response;
		when(requestRepository.save(response1)).thenReturn(response1);
		assertEquals(response1, requestResponseService.saveRequest(response));

	}

}
