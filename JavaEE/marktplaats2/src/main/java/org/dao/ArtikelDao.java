package org.dao;

import org.domain.Artikel;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ArtikelDao extends Dao<Artikel> {
    public ArtikelDao() {}

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


