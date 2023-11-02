package org.example;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Authenticated
@Path("/wiebenik")
public class Whoami {
    //
    @Inject
    SecurityContext context;

    @Inject
    Template wiebenik;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(){
        //
        String username = context.getUserPrincipal().getName();
        return wiebenik.data("naam", username);
    }
}
