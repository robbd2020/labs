package org.dao;

import org.domain.Artikel;
import org.domain.Gebruiker;
import org.domain.Product;
import org.domain.Winkelwagen;

import javax.persistence.EntityManager;
import java.util.List;

public class WinkelwagenDao extends Dao<Winkelwagen, Long>{
    public WinkelwagenDao(EntityManager em) {
        super(em);
    }

    public List<Artikel> getProductLijst(Winkelwagen w){

        return em.createQuery("SELECT a from Artikel a where a.winkelwagen = :wagen").setParameter("wagen", w).getResultList();
    }
}
