package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.GebruikerDao;
import org.example.marktplaats2.domain.Gebruiker;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/gebruikers")
@Produces(MediaType.APPLICATION_JSON) // stuur altijd JSON
public class GebruikerResource extends GenericResource<Gebruiker> {

    @Inject
    public void setDao(GebruikerDao dao) {
        super.dao = dao;
    }

}
