package com.rec.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "com.rec.demo.dao2" })
@EnableTransactionManagement
public class Jpa2Config {

	@Bean(name = "emf2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("ds2") final DataSource dataSource,
			@Qualifier("jva2") final JpaVendorAdapter jpaVendeorAdapter) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
		entityManagerFactory.setPackagesToScan("");
		entityManagerFactory.setPersistenceUnitName("pu2");
		return entityManagerFactory;
	}

	@Bean(name = "jva2")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.SQLServerDialect");
		return adapter;
	}

	@Bean(name = "ds2")
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://172.16.6.184:1433;databaseName=DWHSnap");
		ds.setUsername("usrREC");
		ds.setPassword("usrREC2016");
		return ds;
	}

	@Bean(name = "tm2")
	public PlatformTransactionManager transactionManager(@Qualifier("emf2") final EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
		return transactionManager;
	}

}
