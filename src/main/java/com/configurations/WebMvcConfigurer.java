package com.configurations;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Component
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		org.springframework.web.servlet.config.annotation.WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	

}
