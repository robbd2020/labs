package org.example.marktplaats2.dao;

import org.example.marktplaats2.domain.Product;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProductDao extends Dao<Product> {
    public ProductDao() {
    }

    public List<Product> vindAlleBeschikbare() {
        return em.createNamedQuery(printKlasseNaam() + ".vindAlleBeschikbare", T()).getResultList();
    }

    public List<Product> zoekInAlleBeschikbare(String zoekterm) {
        return em.createNamedQuery(printKlasseNaam() + ".zoekInAlleBeschikbare", T())
                .setParameter(1, "%".concat(zoekterm).concat("%"))
                .setParameter(2, "%".concat(zoekterm).concat("%"))
                .getResultList();
    }

}


