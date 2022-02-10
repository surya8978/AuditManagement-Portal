package com.audit.jwtauditmanagement.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.audit.jwtauditmanagement.model.ManagerService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	ManagerService managerService;

	/*
	  This method guaranteed to be just invoked once per request within a single
	  request thread.
	 */

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authHeadder = request.getHeader("Authorization");
		String username = null;
		String jwt = null;
		log.debug(authHeadder);

		if (authHeadder != null && authHeadder.startsWith("Bearer ")) {
			jwt = authHeadder.substring(7);
			try {
				username = jwtUtil.extractUsername(jwt);

			} catch (IllegalArgumentException e) {
				log.error("illegal argument");
			} catch (ExpiredJwtException e) {
				log.error("token expired");

			} catch (SignatureException e) {
				log.error("authentication failed");
			}
		} else {
			log.warn("token not found");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.managerService.loadUserByUsername(username);

			if (jwtUtil.validateToken(jwt)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}

		filterChain.doFilter(request, response);
	}
}
