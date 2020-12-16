package org.example.marktplaats2.dao;

import lombok.NoArgsConstructor;
import org.example.marktplaats2.domain.Product;

import javax.ejb.Stateless;
import java.util.List;

@NoArgsConstructor
@Stateless
public class ProductDao extends Dao<Product> {

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
