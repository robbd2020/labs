package org.resources;

import org.dao.ArtikelDao;
import org.domain.Artikel;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/artikelen")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class ArtikelResource extends GenericResource<Artikel> {

    @Inject
    public void setDao(ArtikelDao dao){
        super.dao = dao;
    }

}
