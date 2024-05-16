package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class RootConfig {

    @Autowired
    private Environment environment;

    // JDBC and Hibernate Configurations
    @Bean
    public LocalSessionFactoryBean sessionFactory () {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties();
        sessionFactory.setPackagesToScan(new String[]{"com.tpe.domain"});

        return sessionFactory;
    }

    private DataSource dataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
    }

}
