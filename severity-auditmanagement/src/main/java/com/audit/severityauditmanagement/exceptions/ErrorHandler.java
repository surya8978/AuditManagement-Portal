package com.audit.severityauditmanagement.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.audit.severityauditmanagement.exceptions.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {


	
	@ExceptionHandler(FeignProxyException.class)
	public ResponseEntity<CustomErrorResponse> handelFeignProxyException(FeignProxyException ex) {
		log.debug("FeignProxyException",ex);
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("feign is null");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}

