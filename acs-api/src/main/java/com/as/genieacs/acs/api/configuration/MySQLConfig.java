package com.as.genieacs.acs.api.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.as.genieacs.acs.entity.mysql", 
		entityManagerFactoryRef = "mysqlEntityManager", 
		transactionManagerRef = "mysqlTransactionManager")
public class MySQLConfig {

	@Bean(name = "mysqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlEntityManager")
	LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("mysqlDataSource") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(new String[] { "com.as.genieacs.acs.entity.mysql" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		return em;
	}

	@Bean(name = "mysqlTransactionManager")
	JpaTransactionManager transactionManager(
			@Qualifier("mysqlEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
		return transactionManager;
	}

}
