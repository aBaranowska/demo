package com.rec.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ JpaConfig.class, Jpa2Config.class, PropertyConfig.class })
public class AppConfig {

	@Bean
	CustomBeanPostProcessor beanPostProcessor() {
		return new CustomBeanPostProcessor();
	}

}
