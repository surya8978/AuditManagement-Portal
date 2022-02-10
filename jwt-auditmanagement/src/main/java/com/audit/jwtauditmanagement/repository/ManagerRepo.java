package com.audit.jwtauditmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audit.jwtauditmanagement.model.AuditManager;


@Repository
public interface ManagerRepo extends JpaRepository<AuditManager, String>{

}
