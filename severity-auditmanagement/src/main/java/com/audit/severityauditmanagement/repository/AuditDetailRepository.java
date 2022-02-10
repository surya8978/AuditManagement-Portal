package com.audit.severityauditmanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.severityauditmanagement.model.AuditDetails;
@Repository
public interface AuditDetailRepository extends JpaRepository<AuditDetails, Integer>{


}

