package com.audit.jwtauditmanagement.model;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResponse {

	private String uid;

	
	private boolean isValid;
	
	 
	}

