package com.mycompany.complaintregistration.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author srini
 */
@Configuration
@EnableJpaRepositories(basePackages="com.mycompany.complaintregistration")
@EnableTransactionManagement
public class DataConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        try {
            Context ctx = new InitialContext();
            return (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDS");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws NamingException {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.ORACLE);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.mycompany.complaintregistration.dao");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public org.springframework.orm.hibernate3.HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new org.springframework.orm.hibernate3.HibernateExceptionTranslator();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}
