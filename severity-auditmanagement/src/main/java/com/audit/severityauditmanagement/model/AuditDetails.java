package com.audit.severityauditmanagement.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auditdetail")
public class AuditDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AuditId")
	private int auditId;
	@Column(name = "AuditType")
	private String auditType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "auditdate")
	private Date auditDate;
	
	@Column(name = "questionResponse")
	private Integer questionResponse;
	
	@PrePersist
	protected void onCreate() {
		auditDate = new Date();
	}
	
}

