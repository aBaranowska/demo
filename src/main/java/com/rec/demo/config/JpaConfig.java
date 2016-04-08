package com.rec.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "com.rec.demo.dao", "com.rec.demo.service" })
@EnableTransactionManagement
public class JpaConfig {

	@Bean(name = "emf")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("ds") final DataSource dataSource,
			@Qualifier("jva") final JpaVendorAdapter jpaVendeorAdapter) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
		entityManagerFactory.setPackagesToScan("com.rec.demo.entity");
		entityManagerFactory.setPersistenceUnitName("pu");
		return entityManagerFactory;
	}

	@Bean(name = "jva")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
		return adapter;
	}

	@Bean(name = "ds")
	DataSource dataSource() {
		EmbeddedDatabase ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		return ds;
	}

	@Bean(name = "tm")
	public PlatformTransactionManager transactionManager(@Qualifier("emf") final EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
		return transactionManager;
	}

}
