package org.resources;

import org.dao.ProductDao;
import org.dao.Dao;
import org.domain.Artikel;
import org.domain.Product;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/producten")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class ProductResource extends GenericResource<Product> {

    private ProductDao getDao() {
        return (ProductDao) this.dao;
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
