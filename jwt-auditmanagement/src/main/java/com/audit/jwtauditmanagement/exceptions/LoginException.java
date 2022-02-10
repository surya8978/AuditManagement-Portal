package com.audit.jwtauditmanagement.exceptions;

import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@NoArgsConstructor
public class LoginException extends RuntimeException {


	public LoginException(String message) {
		super(message);
	}
	public LoginException(Throwable cause) {
		super(cause);
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}
}
