package com.mycompany;

import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.spring.SpringWebApplicationFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class WebInitializer implements ServletContextInitializer{

    private static final String PARAM_APP_BEAN = "applicationBean";

    @Override
    public void onStartup(ServletContext sc) {
        FilterRegistration filter = sc.addFilter("wicket-filter", WicketFilter.class);
        filter.setInitParameter(WicketFilter.APP_FACT_PARAM, SpringWebApplicationFactory.class.getName());
        filter.setInitParameter(PARAM_APP_BEAN, "wicketApplication");
		// This line is the only surprise when comparing to the equivalent
        // web.xml. Without some initialization seems to be missing.
        filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        filter.addMappingForUrlPatterns(null, false, "/*");
    }

}
