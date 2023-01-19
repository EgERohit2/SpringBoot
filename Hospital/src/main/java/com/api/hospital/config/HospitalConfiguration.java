package com.api.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.api.hospital.interceptor.HospitalInterceptor;

@Configuration
public class HospitalConfiguration implements WebMvcConfigurer{

	@Autowired
	HospitalInterceptor hospitalInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(hospitalInterceptor);
	}
	
	
}
