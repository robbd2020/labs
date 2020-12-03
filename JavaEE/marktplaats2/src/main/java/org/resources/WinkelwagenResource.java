package org.resources;

import org.dao.WinkelwagenDao;
import org.domain.Winkelwagen;

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
