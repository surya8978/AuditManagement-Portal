package com.audit.severityauditmanagement.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "auditresponse")
public class AuditResponseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ResponseId")
	private int responseId;
	@Column(name = "ExecutionStatus")
	private String executionStatus;
	@Column(name = "ActionDuration")
	private String duration;
	@Column(name = "ProjectName")
	private String projectName;
	@Column(name = "ManagerName")
	private String managerName;
	@Column(name = "OwnerName")
	private String ownerName;
	@Column(name = "AuditType")
	private String auditType;
	@Column(name = "auditDate")
	private Date auditDate;
 
	
}

