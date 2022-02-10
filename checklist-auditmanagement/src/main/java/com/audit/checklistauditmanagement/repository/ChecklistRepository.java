package com.audit.checklistauditmanagement.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.checklistauditmanagement.model.AuditQuestions;

@Repository
public interface ChecklistRepository extends JpaRepository<AuditQuestions, Integer>{
	
	List<AuditQuestions> findByAuditType(String auditType);
	

}
