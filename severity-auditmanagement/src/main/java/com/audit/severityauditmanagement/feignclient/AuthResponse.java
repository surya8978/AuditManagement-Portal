package com.audit.severityauditmanagement.feignclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	
	private String uid;
	
	private boolean isValid;
	
}

