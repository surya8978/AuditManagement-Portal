package com.audit.jwtauditmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableSwagger2
public class JwtAuditmanagementApplication {
	
	//adding generater to make main class ignore in testcoverage
		@Generated
	public static void main(String[] args) {
		
		SpringApplication.run(JwtAuditmanagementApplication.class, args);
	}

}
