package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan ("com.tpe")
@EnableWebMvc   //to enable MVC
public class WebMvcConfig implements WebMvcConfigurer {

    // if we have some static pages, we don't send them to servlet
    // they don't need any processing
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**")   // setting url path for statics
                .addResourceLocations("/resources/") // resource path for static file
                .setCachePeriod(0); // cache period which should be updated
    }


    // view resolver config, enables us to build Bean inside our jsp file with java code
    @Bean
    public InternalResourceViewResolver resolver () {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp"); // "/WEB-INF/views/hi.jsp"
        // it helps us to run sum java codes inside our jsp file => JavaStandardTagLibrary: to write some basic codes inside JSP
        resolver.setViewClass(JstlView.class);

        return resolver;
    }
}
