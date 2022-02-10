package com.audit.jwtauditmanagement.exceptions;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.audit.jwtauditmanagement.exceptions.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class ErrorHandler {


	@ExceptionHandler(LoginException.class)
	public ResponseEntity<CustomErrorResponse> handleIdNotFoundexception(LoginException ex) {
		log.debug("LoginFailedException",ex);
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"Invalid Credentials", ex.getMessage());
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}



	@ExceptionHandler(TokenException.class)
	public ResponseEntity<CustomErrorResponse> handleTokenNotFoundexception(TokenException ex) {
		log.debug("TokenExpiredException",ex);
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"the token is expired and not valid anymore", ex.getMessage());

		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleUserNotFoundexception(UsernameNotFoundException ex) {
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"Invalid Credentials", ex.getMessage());
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
}
