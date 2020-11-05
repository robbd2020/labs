package org.dao;

import org.domain.Gebruiker;
import org.domain.Winkelwagen;

import javax.persistence.EntityManager;

public class WinkelwagenDao extends Dao<Winkelwagen, Long>{
    public WinkelwagenDao(EntityManager em) {
        super(em);
    }
}
