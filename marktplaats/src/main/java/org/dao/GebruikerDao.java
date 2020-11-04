package org.dao;

import org.domain.Gebruiker;

import javax.persistence.EntityManager;

public class GebruikerDao extends Dao<Gebruiker, Long> {
    public GebruikerDao(EntityManager em) {
        super(em);
    }
}

