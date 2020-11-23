package com.configurations;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages= {"com.repositories"}, entityManagerFactoryRef="bookEntityManagerFactory", transactionManagerRef="bookTxManager")
public class BookConfiguration {
	
	@ConfigurationProperties(value="spring.book.datasource")
	@Bean(name="bookDataSource")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEMFB(EntityManagerFactoryBuilder builder, 
			@Qualifier("bookDataSource") DataSource dataSource) {
		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		return builder.dataSource(dataSource).properties(properties).packages("com.entities").persistenceUnit("BookEntity").build();
	}
	
	@Bean(name="bookTxManager")
	public PlatformTransactionManager getTxManager(@Qualifier("bookEntityManagerFactory") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	
}
