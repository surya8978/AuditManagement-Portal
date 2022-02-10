package com.audit.severityauditmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.prototype.auditseverity.feignclients.AuditBenchmarkFeign;
//import com.audit.severityauditmanagement.feignclient.AuditCheckListFeign;
import com.audit.severityauditmanagement.model.AuditRequestDetails;
import com.audit.severityauditmanagement.model.AuditResponseDetails;
import com.audit.severityauditmanagement.repository.AuditDetailRepository;
import com.audit.severityauditmanagement.repository.RequestRepository;
import com.audit.severityauditmanagement.repository.ResponseRepository;

@Service
public class RequestResponseService {

	@Autowired
	AuditDetailRepository auditDetailRepository;

	@Autowired
	RequestRepository requestRepository;

	@Autowired
	ResponseRepository responseRepository;

	public AuditRequestDetails saveRequest(AuditRequestDetails request) {
		return requestRepository.save(request);
	}


	public AuditResponseDetails saveResponse(AuditResponseDetails response) {
		return responseRepository.save(response);
	}

}

