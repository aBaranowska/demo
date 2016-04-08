package com.rec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertyConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer configurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
