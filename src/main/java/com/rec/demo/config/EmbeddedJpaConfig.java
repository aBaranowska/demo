package com.rec.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class EmbeddedJpaConfig {

	public static final String PU = "embedded_pu";
	public static final String EMF = "embedded_emf";
	public static final String JPA_VA = "embedded_jpa_va";
	public static final String DS = "embedded_ds";
	public static final String TM = "embedded_tm";
	public static final String PACKAGES = "com.rec.demo.entity.embedded";
	public static final String DIALECT = "org.hibernate.dialect.H2Dialect";

	@Bean(name = EMF)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(DS) final DataSource dataSource,
			@Qualifier(JPA_VA) final JpaVendorAdapter jpaVendeorAdapter) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
		entityManagerFactory.setPackagesToScan(PACKAGES);
		entityManagerFactory.setPersistenceUnitName(PU);
		return entityManagerFactory;
	}

	@Bean(name = JPA_VA)
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform(DIALECT);
		return adapter;
	}

	@Bean(name = DS)
	DataSource dataSource() {
		EmbeddedDatabase ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		return ds;
	}

	@Bean(name = TM)
	public PlatformTransactionManager transactionManager(@Qualifier(EMF) final EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
		return transactionManager;
	}

}
