package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
}
