package com.audit.severityauditmanagement.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "auditrequest")
public class AuditRequestDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RequestId")
	private int requestId;
	@OneToOne(cascade = CascadeType.ALL)
	private AuditDetails auditDetails;
	@Column(name = "ProjectName")
	private String projectName;
	@Column(name = "ManagerName")
	private String managerName;
	@Column(name = "OwnerName")
	private String ownerName;

	
}
