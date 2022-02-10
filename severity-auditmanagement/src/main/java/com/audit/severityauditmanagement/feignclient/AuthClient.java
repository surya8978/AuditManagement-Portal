package com.audit.severityauditmanagement.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


//for AWS
//@FeignClient(url = "${fos.auth}",name = "jwt-auditmanagement")

@FeignClient(name = "jwt-auditmanagement")
public interface AuthClient {

	@GetMapping(value = "/auth/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token);

}
