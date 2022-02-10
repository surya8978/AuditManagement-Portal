package com.audit.severityauditmanagement.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * This class is used as a response of error handling message. In the
 * ErrorHandler class CustomErrorResponse class is used as
 * a return type that will be shown to the client whenever any kind of exception
 * occurs. The variables of this class is used to describe the Exception.
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {


	private LocalDateTime timestamp;
	
	private HttpStatus status;
	
	private String reason;
	

	private String message;

}

