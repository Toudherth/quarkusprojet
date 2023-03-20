package org.acme.service;
import org.acme.entity.Offre;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/offre")
@RegisterRestClient
public interface OffreService {
    @GET
    @Path("/{id}")
    Offre getOffre(@PathParam("id") Long id );
    
    @GET
    List<Offre> getAllOffres() ; //{return (List<Offre>) offreService.getAllOffre();}
}
