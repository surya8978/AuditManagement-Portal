package com.audit.jwtauditmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.audit.jwtauditmanagement.exceptions.LoginException;
import com.audit.jwtauditmanagement.model.AuthResponse;
import com.audit.jwtauditmanagement.model.AuditManager;
import com.audit.jwtauditmanagement.model.UserCredentials;
import com.audit.jwtauditmanagement.security.JwtUtil;
import com.audit.jwtauditmanagement.model.ManagerService;

import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class AuthController {

	@Autowired
	ManagerService managerService;

	
	@Autowired
	JwtUtil jwtUtil;
	
	@Value("${audit.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody UserCredentials userCredentials) throws Exception {
		 log.debug(userCredentials.toString());

		final UserDetails userDetails = managerService.loadUserByUsername(userCredentials.getUserId());

		if (userDetails.getPassword().equals(userCredentials.getPassword())) {
			String token = jwtUtil.generateToken(userDetails);
			AuditManager auditManager = new AuditManager(userCredentials.getUserId(),
					userCredentials.getPassword(),token,jwtExpirationMs);
			managerService.saveUser(auditManager);
			return new ResponseEntity<>(new AuditManager(userCredentials.getUserId(),
					null,token,jwtExpirationMs), HttpStatus.OK);

		} else {
			log.info("access denied");
			throw new LoginException("Invalid Credentials");
		}
	}


	@GetMapping(value = "/auth/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
		
		  if(token.contains("Bearer")) { 
			  token = token.replace("Bearer ", ""); 
			  }
		AuthResponse res = new AuthResponse();
		ResponseEntity<?> response = null;
		 log.debug("auth token", token);
		try {
			
			if (jwtUtil.validateToken(token)) {

				res.setUid(jwtUtil.extractUsername(token));
				res.setValid(true);

			}
		} catch (Exception e) {
			res.setValid(false);
			 log.info("exception ", e.getMessage());
			System.out.println(e.getMessage());
			response = new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
			return response;
		}
		response = new ResponseEntity<AuthResponse>(res, HttpStatus.OK);
		return response;

	}

}

