package com.api.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.api.hospital.interceptor.HospitalInterceptor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2        // (http://localhost:8080/api/swagger-ui/#/) -> link for swagger 
public class HospitalConfiguration implements WebMvcConfigurer{

	@Autowired
	HospitalInterceptor hospitalInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(hospitalInterceptor);
	}
	
	
	
}
