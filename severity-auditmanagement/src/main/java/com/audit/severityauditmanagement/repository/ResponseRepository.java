package com.audit.severityauditmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.severityauditmanagement.model.AuditResponseDetails;


@Repository
public interface ResponseRepository extends JpaRepository<AuditResponseDetails, Integer> {

}

