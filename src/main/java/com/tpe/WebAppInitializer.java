package com.tpe;

// We'll use this class as the replacement of web.xml file. A web.xml file is a configuration file for Java based
// Web Applications

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class };
    }

    @Override   // All the requests with incoming URL.
    protected String[] getServletMappings() {
        return new String[] { "/" };    // -> /students/new/1 -> Still starts with '/', so, it'll be included
    }
}
