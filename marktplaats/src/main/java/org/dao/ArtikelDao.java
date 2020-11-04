package org.dao;

import org.domain.Artikel;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtikelDao extends Dao<Artikel, Long> {
    public ArtikelDao(EntityManager em) {
        super(em);
    }

    public List<Artikel> vindAlleBeschikbare(){
        return em.createNamedQuery(typeSimple() + ".vindAlleBeschikbare", T()).getResultList();
    }

    public List<Artikel> vindAlleBeschikbare2(){
        return em.createQuery("Select a from Artikel a").getResultList();
    }
}


