package org.example;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/verbruik")
@Blocking
public class VerbruikResource {
    //
    @Inject
    SecurityContext context;

    @Inject
    Template rapport;

    @RestClient
    VerbruikClient client;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(){
        //
        List<Energiemetingen> metingen = client.getVerbruik("1");
        return rapport.data("metingen", metingen);
    }
}
