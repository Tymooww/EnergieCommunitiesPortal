package org.example;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/metingen")
@Blocking
public class EnergiemetingenResource {
    //
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance rapport(
                List<Energiemetingen> metingen);
    }

    @Inject
    SecurityContext context;

    @RestClient
    EnergiemetingenClient client;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getEnergiemetingen() {
        //
        String username = context.getUserPrincipal().getName();
        List<Energiemetingen> metingen = client.getEnergiemetingen(username.substring(username.length() - 1));
        return Templates.rapport(metingen);
    }
}
