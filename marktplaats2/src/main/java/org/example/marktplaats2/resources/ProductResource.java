package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.ProductDao;
import org.example.marktplaats2.dao.Dao;
import org.example.marktplaats2.domain.Product;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/producten")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class ProductResource extends GenericResource<Product> {

    private ProductDao getDao() {
        return (ProductDao) this.dao;
    }

    @Path("/zoeken")
    @GET
    public List<Product> getAll(@QueryParam("q") String q) {
        return q == null ? dao.getAllWithNamedQuery() : getDao().zoekInAlleBeschikbare(q);
    }

    @Path("/alleBeschikbare")
    @GET
    public List<Product> getAlleBeschikbare() {
        return getDao().vindAlleBeschikbare();
    }

    @Inject
    public void setDao(Dao<Product> dao) {
        super.dao = dao;
    }

}
