package com.audit.severityauditmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.audit.severityauditmanagement.exceptions.FeignProxyException;
import com.audit.severityauditmanagement.feignclient.AuthClient;
import com.audit.severityauditmanagement.feignclient.AuthResponse;

//import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthTokenService implements AuthTokenServiceInt {

	
	@Autowired
	private AuthClient authClient;
	
	public Boolean checkTokenValidity(String token) {
    	log.debug("token",token);
		try {
			
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if (authResponse == null)
				throw new Exception();
			return authResponse.isValid();
		} 
		catch (Exception e) {
			return false;
		}

	}

}
