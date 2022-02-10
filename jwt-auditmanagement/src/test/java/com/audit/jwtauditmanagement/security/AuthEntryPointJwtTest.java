package com.audit.jwtauditmanagement.security;

import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AuthEntryPointJwtTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private AuthEntryPointJwt authEntryPointJwt;

    @Test
    public void mapsToError() throws Exception {
    	authEntryPointJwt.commence(request, response, new TestException("message", new RuntimeException()));
        verify(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }

    static class TestException extends AuthenticationException {

		private static final long serialVersionUID = 1L;

		TestException(String msg, Throwable t) {
            super(msg, t);
        }
    }
}