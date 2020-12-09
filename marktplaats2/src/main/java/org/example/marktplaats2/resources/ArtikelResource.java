package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.ArtikelDao;
import org.example.marktplaats2.dao.Dao;
import org.example.marktplaats2.domain.Artikel;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/artikelen")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class ArtikelResource extends GenericResource<Artikel> {

    private ArtikelDao getDao() {
        return (ArtikelDao) this.dao;
    }

    @Path("/alleBeschikbare")
    @GET
    public List<Artikel> getAlleBeschikbare() {
        return getDao().vindAlleBeschikbare();
    }

    @Inject
    public void setDao(Dao<Artikel> dao) {
        super.dao = dao;
    }

}