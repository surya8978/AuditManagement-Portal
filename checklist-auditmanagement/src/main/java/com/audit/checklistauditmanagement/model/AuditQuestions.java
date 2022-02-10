package com.audit.checklistauditmanagement.model;


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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AuditQuestions")
public class AuditQuestions {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "questionId")
	private int questionId;

	@Column(name = "auditType")
	private String auditType;


	@Column(name = "questions") 
	private String questions;


}
