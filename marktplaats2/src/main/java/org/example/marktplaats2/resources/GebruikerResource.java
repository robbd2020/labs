package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.GebruikerDao;
import org.example.marktplaats2.domain.Gebruiker;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/gebruikers")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class GebruikerResource extends GenericResource<Gebruiker> {


    @Inject
    public void setDao(GebruikerDao dao) {
        super.dao = dao;
    }

}
