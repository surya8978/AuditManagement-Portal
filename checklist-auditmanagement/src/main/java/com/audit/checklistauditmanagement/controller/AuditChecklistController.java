package com.audit.checklistauditmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.audit.checklistauditmanagement.exceptions.AuditTypeException;
import com.audit.checklistauditmanagement.model.AuditQuestions;
import com.audit.checklistauditmanagement.services.AuthTokenService;
import com.audit.checklistauditmanagement.services.ChecklistService;

import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class AuditChecklistController {

	@Autowired
	ChecklistService service;

	@Autowired
	AuthTokenService tokenService;
	
	final String inValidAuditType="invalid audit type";
	final String tokenExpired="the token is expired and not valid anymore";

	@GetMapping("/checklist/{auditType}")
	public ResponseEntity<?> getQuestions(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable String auditType) {
		
		List<AuditQuestions> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if (tokenService.checkTokenValidity(token)) {
			try {
				questionsList = service.getQuestions(auditType);
			} catch (AuditTypeException e) {
				responseEntity = new ResponseEntity<String>(inValidAuditType, HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
			}
			responseEntity = new ResponseEntity<List<AuditQuestions>>(questionsList, HttpStatus.OK);
			return responseEntity;

		} 
			  else { 
				  log.error("token expired"); 
				  responseEntity = new ResponseEntity<String>(tokenExpired, HttpStatus.FORBIDDEN);
			  return responseEntity; 
			  }
			 

	}

}
