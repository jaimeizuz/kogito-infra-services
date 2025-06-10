package org.kie.kogito.hr.rest.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@ApplicationScoped
@RegisterRestClient(configKey = "dummy-rest-service")
@Path("/dummy")
public interface DummyRestClient {

    /**
     * Retrieves operational entities.
     *
     * Retrieves operational entities filtering by GLCS (Global Limit Code System).
     *
     */
    @GET
    @Produces({ "application/json" })
    Response getDummy();

}
