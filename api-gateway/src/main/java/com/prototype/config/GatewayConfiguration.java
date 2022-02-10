package com.prototype.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class GatewayConfiguration {

	@Bean
	public RouteLocator router(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/auth/**").uri("lb://JWT-AUDITMANAGEMENT"))
				.route(p -> p.path("/checklist/**").uri("lb://CHECKLIST-AUDITMANAGEMENT"))
				.route(p -> p.path("/severity/**").uri("lb://SEVERITY-AUDITMANAGEMENT"))
				.build();
	}
	@Bean
	   public CorsWebFilter corsWebFilter() {

	       org.springframework.web.cors.CorsConfiguration corsConfig = new org.springframework.web.cors.CorsConfiguration();
	       corsConfig.setAllowedOrigins(Collections.singletonList("*"));
	       corsConfig.setMaxAge(3600L);
	       corsConfig.setAllowedMethods(Arrays.asList("GET", "POST"));
	       corsConfig.addAllowedHeader("*");

	       final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	       source.registerCorsConfiguration("/**", corsConfig);

	       return new CorsWebFilter(source);
	   }
}
