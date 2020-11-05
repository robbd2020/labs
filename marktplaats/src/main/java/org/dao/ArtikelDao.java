package org.dao;

import org.domain.Artikel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtikelDao extends Dao<Artikel, Long> {
    public ArtikelDao(EntityManager em) {
        super(em);
    }

    public List<Artikel> vindAlleBeschikbare(){
        return em.createNamedQuery(typeSimple() + ".vindAlleBeschikbare", T()).getResultList();
    }


    public List<Artikel> zoekInAlleBeschikbare(String zoekterm){
        return em.createNamedQuery(typeSimple() + ".zoekInAlleBeschikbare", T()).setParameter(1, "%".concat(zoekterm).concat("%")).setParameter(2,"%".concat(zoekterm).concat("%")). getResultList();
    }


}


