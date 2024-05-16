package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:db.properties")
public class RootConfig {

    @Autowired
    private Environment environment;

    // JDBC and Hibernate Configurations
    @Bean
    public LocalSessionFactoryBean sessionFactory () {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();


        return sessionFactory;
    }

}
