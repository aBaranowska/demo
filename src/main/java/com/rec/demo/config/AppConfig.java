package com.rec.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({ EmbeddedJpaConfig.class, SQLServerJpaConfig.class, PropertyConfig.class })
@ComponentScan({ "com.rec.demo.dao", "com.rec.demo.service" })
@EnableTransactionManagement
public class AppConfig {

	@Bean
	CustomBeanPostProcessor beanPostProcessor() {
		return new CustomBeanPostProcessor();
	}

}
