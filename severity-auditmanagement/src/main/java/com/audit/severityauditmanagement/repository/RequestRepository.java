package com.audit.severityauditmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.severityauditmanagement.model.AuditRequestDetails;



@Repository
public interface RequestRepository extends JpaRepository<AuditRequestDetails, Integer>{

}

