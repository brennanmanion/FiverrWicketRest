package com.mycompany;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/javax")
public class JavaxRsConfig extends ResourceConfig {

    public JavaxRsConfig() {
        register(JavaxRestApi.class);
    }

}
