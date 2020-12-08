package org.resources;

import org.dao.GebruikerDao;
import org.domain.Artikel;
import org.domain.Gebruiker;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/gebruikers")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class GebruikerResource extends GenericResource<Gebruiker> {


    @Inject
    public void setDao(GebruikerDao dao) {
        super.dao = dao;
    }

}
