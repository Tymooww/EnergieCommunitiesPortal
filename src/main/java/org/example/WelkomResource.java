package org.example;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

//@Authenticated
@Path("/welkom")
public class WelkomResource {
    //
    @Inject
    SecurityContext context;

    @Inject
    Template welkom;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        //
        String username = context.getUserPrincipal().getName();
        return welkom.data("naam", username);
    }
}
