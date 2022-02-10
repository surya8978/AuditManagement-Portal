package com.audit.severityauditmanagement.controller;
import java.util.Date;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.audit.severityauditmanagement.feignclient.AuditCheckListFeign;
import com.audit.severityauditmanagement.model.AuditRequestDetails;
import com.audit.severityauditmanagement.model.AuditResponseDetails;
//import com.audit.severityauditmanagement.model.QuestionsEntity;
import com.audit.severityauditmanagement.services.RequestResponseService;
import com.audit.severityauditmanagement.services.AuthTokenServiceInt;

import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/severity")
public class AuditSeverityController {

	@Autowired
	RequestResponseService requestResponseService;

	@Autowired
	Environment env;

	@Autowired
	AuthTokenServiceInt tokenService;
	
	final String internal="Internal";
	final String other="Other";
	final String greenStatus="Green";
	final String redStatus="Red";
	final String week2="Action to be taken in 2 weeks";
	final String week1="Action to be taken in 1 weeks";
	final String noAction="No action required";
	final String tokenExpired="the token is expired and not valid anymore";
	


	@PostMapping("executionStatus")
	public ResponseEntity<?> getExceutionStatus(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody AuditRequestDetails request) {
		log.debug("Auditrequest",request);
		ResponseEntity<?> responseEntity = null;
		AuditResponseDetails response = null;
		int noNos = request.getAuditDetails().getQuestionResponse();
		int actualNos = 3;
		String managerName = request.getManagerName();
		String projectName = request.getProjectName();
		String auditType2 = request.getAuditDetails().getAuditType();
		Date auditDate = request.getAuditDetails().getAuditDate();
		String ownerName = request.getOwnerName();

 
		if (tokenService.checkTokenValidity(token)) {
			
			String auditType = request.getAuditDetails().getAuditType();

			if (auditType.equalsIgnoreCase(internal) && noNos <= actualNos) {
				response = new AuditResponseDetails(1, greenStatus, noAction, projectName, managerName, ownerName,
						auditType2, auditDate);
			} else if (auditType.equalsIgnoreCase(internal) && noNos > actualNos) {
				response = new AuditResponseDetails(2, redStatus, week2, projectName, managerName,
						ownerName, auditType2, auditDate);
			} else if (auditType.equalsIgnoreCase(other) && noNos <= actualNos) {
				response = new AuditResponseDetails(3, greenStatus, noAction, projectName, managerName, ownerName,
						auditType2, auditDate);
			} else if (auditType.equalsIgnoreCase(other) && noNos > actualNos) {
				response = new AuditResponseDetails(4, redStatus, week1, projectName, managerName,
						ownerName, auditType2, auditDate);
			}
			requestResponseService.saveResponse(response);
			requestResponseService.saveRequest(request);
			responseEntity = new ResponseEntity<AuditResponseDetails>(response, HttpStatus.OK);
			return responseEntity;
		} 
			  else { 
				  log.error("token expired"); 
				  responseEntity = new ResponseEntity<String>(tokenExpired, HttpStatus.FORBIDDEN);
				  return
			  responseEntity; }
			 
	}
}
