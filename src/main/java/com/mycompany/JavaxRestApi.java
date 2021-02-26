package com.mycompany;

import org.springframework.stereotype.Service;

import javax.ws.rs.*;


@Service
@Path("/api")
public class JavaxRestApi {

    @POST
    @Path("/customer")
    @Consumes("text/plain")
    @Produces("text/plain")
    public String createNewCustomer (String newCustomerData){
        String[] customerFields = newCustomerData.split(",");
        return (customerFields[0] + " has been created successfully");
    }

    @GET
    @Path("/test")
    @Produces("text/plain")
    public String testWS (){
        return  "Javax REST API is working";
    }
}
