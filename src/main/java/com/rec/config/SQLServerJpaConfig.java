package com.rec.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SQLServerJpaConfig {

	public static final String PU = "sqlserver_pu";
	public static final String EMF = "sqlserver_emf";
	public static final String JPA_VA = "sqlserver_jpa_va";
	public static final String DS = "sqlserver_ds";
	public static final String TM = "sqlserver_tm";
	public static final String PACKAGES = "";
	public static final String DIALECT = "org.hibernate.dialect.SQLServerDialect";
	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	@Value("${dbUrl}")
	private String dbUrl;

	@Value("${dbUser}")
	private String dbUser;

	@Value("${dbPassword}")
	private String dbPassword;

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
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform(DIALECT);
		return adapter;
	}

	@Bean(name = DS)
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(dbUrl);
		ds.setUsername(dbUser);
		ds.setPassword(dbPassword);
		return ds;
	}

	@Bean(name = TM)
	public PlatformTransactionManager transactionManager(@Qualifier(EMF) final EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
		return transactionManager;
	}

}
