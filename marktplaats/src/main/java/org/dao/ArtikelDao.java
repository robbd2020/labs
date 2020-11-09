package org.dao;

import org.domain.Artikel;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtikelDao extends Dao<Artikel, Long> {
    public ArtikelDao(EntityManager em) {
        super(em);
    }

    public List<Artikel> vindAlleBeschikbare() {
        return em.createNamedQuery(printKlasseNaam() + ".vindAlleBeschikbare", T()).getResultList();
    }

    public List<Artikel> zoekInAlleBeschikbare(String zoekterm) {
        return em.createNamedQuery(printKlasseNaam() + ".zoekInAlleBeschikbare", T())
                .setParameter(1, "%".concat(zoekterm).concat("%"))
                .setParameter(2, "%".concat(zoekterm).concat("%"))
                .getResultList();
    }

}


