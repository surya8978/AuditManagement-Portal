package com.audit.jwtauditmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.audit.jwtauditmanagement.model.ManagerService;

/*
This class is used for the security configuration. It extends the class WebSecurityConfigurerAdapter 
It will take care of the authentication and authorization based on the user credentials.
*/

//@SuppressWarnings("deprecation")
@EnableWebSecurity

public class WebConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	/*
	  This methods used to override the credentials which spring automatically generates 
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		super.configure(auth);
		auth.userDetailsService(managerService);
	
	}
	
	/*
	  This method is used to inject a AuthenticationManager type bean We
	  are annotating this method with @Bean
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/auth/*").permitAll().anyRequest().authenticated()
		.and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().cacheControl().disable();
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs","/configuration/ui",
				"/swagger-resources/**","/configuration/security","/swagger-ui.html","/webjars/**","/auth/swagger","/h2-console/**");
	}

}
