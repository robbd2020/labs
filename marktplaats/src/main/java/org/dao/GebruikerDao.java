package org.dao;

import org.domain.Account;
import org.domain.Gebruiker;

import javax.persistence.EntityManager;

public class GebruikerDao extends Dao<Gebruiker, Long> {
    public GebruikerDao(EntityManager em) {
        super(em);
    }

//    public Gebruiker vindGebruikerVanWinkelwagen(Long winkelwagenid){
//        return em.createNamedQuery(printKlasseNaam() + ".vindMetWinkelwagen", T()).setParameter(":winkelwagen_id", winkelwagenid).getSingleResult();
//    }

    public Account vindAccountMetEmailEnWw(String email, String ww) {
        return em.createNamedQuery("Account.vindAccountMetEmailAdresEnWw", Account.class).setParameter("email", email).setParameter("wachtwoord", ww).getSingleResult();
    }

}

