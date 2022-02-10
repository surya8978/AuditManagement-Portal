package com.audit.jwtauditmanagement.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "auditManager")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuditManager {
	@Id
	@Column(name = "userid", length = 20)
	private String userId;

	@JsonIgnore
	@Column(name = "password", length = 20)
	private String password;

	
	@Column(name = "authtoken")
	private String authToken;
	
	private int jwtExpirationMs;
	
}
