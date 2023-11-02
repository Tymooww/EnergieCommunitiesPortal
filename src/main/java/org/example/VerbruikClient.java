package org.example;

import io.quarkus.oidc.token.propagation.AccessToken;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8080")
@AccessToken
@Path("/api/rapport")
public interface VerbruikClient {

    @GET
    @Path("/totaal/{id}")
    List<Energiemetingen> getVerbruik(String id);
}
