package org.acme.controller;

import org.acme.entity.Candidat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/candidat")
@Produces(MediaType.TEXT_PLAIN)
public class CandidatController {

    @GET
    public List<Candidat> getAll() {
        return null; //personService.getAll();
    }
    


}
