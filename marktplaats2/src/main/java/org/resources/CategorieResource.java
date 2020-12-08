package org.resources;

import org.dao.CategorieDao;
import org.domain.Categorie;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/categorieen")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class CategorieResource extends GenericResource<Categorie> {


    @Inject
    public void setDao(CategorieDao dao) {
        super.dao = dao;
    }

}