package com.audit.jwtauditmanagement.exceptions;

import io.jsonwebtoken.ExpiredJwtException;



public class TokenException extends ExpiredJwtException{

	private static final long serialVersionUID = 1L;
	public TokenException(String message)
	{
		super(null, null, message);
	}
}