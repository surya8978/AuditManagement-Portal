package com.audit.checklistauditmanagement.feignclient;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	private String uid;

	private boolean isValid;

}

