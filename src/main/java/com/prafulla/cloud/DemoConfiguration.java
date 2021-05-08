package com.prafulla.cloud;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * I am declaring myself as a configuration. As i am a component I will get auto picked
 * in auto config scanning
 *
 */
@Configuration
public class DemoConfiguration {

	/**
	 * This externalized configuration need to be imported
	 * Otherwise
	 * Description:
			A component required a bean named 'cats' that could not be found.
		Action:
			Consider defining a bean named 'cats' in your configuration.
	 * 
		Why?
		Spring auto config will look for the classes and not methods.
		If the class itself not picked how this will get picked.
		
		Once class get picked either via import or via configuration the beans will get picked too
	 */
	@Bean
	public List<String> cats() {
		return Arrays.asList("Bengal", "Lion");
	}
	
	// Override the defaults in spring boot
	
	//@Bean
	public DispatcherServlet dispatcher() {
		return new DispatcherServlet();
	}
	
	//@Bean
	public ServletRegistrationBean servletRegistration() {
		ServletRegistrationBean servletRegistration = 
				new ServletRegistrationBean(dispatcher(), "/servlet/*");
		servletRegistration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
		return servletRegistration;
	}
}
