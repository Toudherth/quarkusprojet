package org.acme.controller;

import org.acme.entity.Candidat;
import org.acme.entity.Offre;
import org.acme.service.CandidatService;
import org.acme.service.OffreService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/offre")
@Produces(MediaType.TEXT_PLAIN)
public class OffreControlleur {
    @Inject
    @RestClient
    private OffreService offreService;

    @Inject
    private CandidatService candidatService;


    @GET
    public List<Offre> getAllOffres() {return (List<Offre>) offreService.getAllOffres();}


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getId(@PathParam("id") Long id){
        Offre offre = offreService.getOffre(id);
        if( offre != null){
            return Response.ok(offre).build();
        }else {
            return Response.noContent().build();
        }

    }
    /*-----------------------candidater Spontanée --------------------------*/
    // Recherche spontanée :
    /*La recherche normalement est faite de maniere a ce que  les offres seront retournée de maniere est ce que l'utilisateur choisi
     * certain cretere ce qui na pas de relation avec le candidat. si il existe une relation avec le candidat
     * est de sort que le candidat candidatee a cette offre (Candidater */

    @GET
    @Path("/recherche")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOffreSponataner(@QueryParam("metier") String metier,
                                             @QueryParam("ville") String ville,
                                             @QueryParam("periode") String periode){

        List<Offre> listeoffre= offreService.getAllOffres(); //.list();

        for (Offre offre : listeoffre){
            System.out.println(offre.nom_offre);
            if(metier != null && ! offre.metier_offre.equals(metier)){
                continue;
            }
            if(ville != null && !offre.ville.equals(ville)){
                continue;
            }
            if(periode != null && !offre.periode.equals(periode)){
                continue;
            }
            listeoffre.add(offre);
        }
     //   return listeoffre;

      //  List<Offre> listeoffre= (List<Offre>) offreRechercheCandidatureController.getAllOffreSponataner(metier, ville,periode);

        return Response.ok(listeoffre).build();
    }

    /*-----------------------candidater a une offre d'emploi--------------------------*/
    @POST
    @Path("/{id_offre}/{idcandidat}")
    @Transactional
    public Response candidature(@PathParam("id_offre") Long id_offre,@PathParam("idcandidat") Long id_candidat) {
        Offre offre = offreService.getOffre(id_offre);
        Candidat candidat = candidatService.getById(id_candidat);
        System.out.println("-----------------"+offre.nom_offre + "   ici le candidat ------"+candidat.getNom_candidat());
        if (offre == null) {
            throw new NotFoundException();
        }
        // candidat.setOffre(offre);
        //System.out.println("----------------les candidats offre -"+candidat.getOffres());
        candidat= candidatService.getById(candidat.getId_candidat());
        candidatService.UpdateCandidat(id_candidat, candidat);
        return Response.status(Response.Status.CREATED).entity(candidat).build();
    }





}