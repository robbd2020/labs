package org.example.marktplaats2.resources;

import org.example.marktplaats2.dao.GebruikerDao;
import org.example.marktplaats2.domain.Gebruiker;
import org.example.marktplaats2.domain.Login;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Produces( "application/json" )
@Path("/login")
public class LoginResource {

    @Inject
    private GebruikerDao dao;

    @POST
    public Gebruiker getGebruiker(Login g) {
        return (Gebruiker) dao.vindAccountMetEmailEnWw(g.getEmail(), g.getWachtwoord());
    }
}
