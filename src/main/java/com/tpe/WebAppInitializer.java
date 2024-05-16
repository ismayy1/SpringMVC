package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Java based Web Apps configurations need web.xml file
// this class will be used instead of web.xml

// AbstractAnnotationConfig: configurations for dispatcherServlet
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {   // to access db: hibernate, JDBC
        return new Class[] {
                RootConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    // viewResolver, handlerMapper
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {   // url path for Servlet
        return new String[0];
    }
}
