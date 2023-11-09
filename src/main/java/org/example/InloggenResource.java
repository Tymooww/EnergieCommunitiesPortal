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
@Path("/inloggen")
public class InloggenResource {
    //
    @Inject
    SecurityContext context;

    @Inject
    Template inloggen;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        //
        return inloggen.data(null);
    }
}
