package ru.jira.custom.marshalling.demo.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/healthCheck")
public class HealthCheckResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String healthCheck() {
        return "OK";
    }
}
