package org.example;

import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8080")
@AccessToken
@Path("/api/metingen")
public interface EnergiemetingenClient {

    @GET
    @Path("/{id}")
    List<Energiemetingen> getEnergiemetingen(@PathParam("id") String id);
}
