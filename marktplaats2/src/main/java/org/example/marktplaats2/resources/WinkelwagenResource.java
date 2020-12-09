package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.WinkelwagenDao;
import org.example.marktplaats2.domain.Winkelwagen;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/winkelwagens")
@Produces(MediaType.APPLICATION_JSON) // Always send JSON
public class WinkelwagenResource extends GenericResource<Winkelwagen> {

    @Inject
    public void setDao(WinkelwagenDao dao) {
        super.dao = dao;
    }

}
