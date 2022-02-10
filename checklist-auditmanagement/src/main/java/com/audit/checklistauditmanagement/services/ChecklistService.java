package com.audit.checklistauditmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.checklistauditmanagement.exceptions.AuditTypeException;
import com.audit.checklistauditmanagement.model.AuditQuestions;
import com.audit.checklistauditmanagement.repository.ChecklistRepository;



@Service
public class ChecklistService {

	@Autowired
	ChecklistRepository repository;


	public List<AuditQuestions> getQuestions(String auditType) throws AuditTypeException {
		if (repository.findByAuditType(auditType).isEmpty()) {
			return null;
		} else {
			return repository.findByAuditType(auditType);
		}
	}	

}

