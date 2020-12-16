package org.example.marktplaats2.dao;

import lombok.NoArgsConstructor;
import org.example.marktplaats2.domain.Account;
import org.example.marktplaats2.domain.Gebruiker;

import javax.ejb.Stateless;

@NoArgsConstructor
@Stateless
public class GebruikerDao extends Dao<Gebruiker> {

    public Account vindAccountMetEmailEnWw(String email, String ww) {
        return em.createNamedQuery("Account.vindAccountMetEmailAdresEnWw", Account.class).setParameter("email", email).setParameter("wachtwoord", ww).getSingleResult();
    }
}
