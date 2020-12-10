package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.GebruikerDao;
import org.example.marktplaats2.dao.ProductDao;
import org.example.marktplaats2.domain.Gebruiker;
import org.example.marktplaats2.domain.Login;
import org.example.marktplaats2.domain.Product;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/gebruikers")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class GebruikerResource extends GenericResource<Gebruiker> {

    private GebruikerDao getDao() {
        return (GebruikerDao) this.dao;
    }




    @Inject
    public void setDao(GebruikerDao dao) {
        super.dao = dao;
    }

}
