package com.audit.checklistauditmanagement.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.checklistauditmanagement.feignclient.AuthClient;
import com.audit.checklistauditmanagement.feignclient.AuthResponse;

@Service
public class AuthTokenService implements TokenServiceInt{
	
	@Autowired
	private AuthClient authClient;
	
	public Boolean checkTokenValidity(String token)  {
		try {
				 
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if(authResponse==null) throw new Exception();
			return authResponse.isValid();	
		}
			catch(Exception e) {
				return false;
			}
		
	}
}
