package org.dao;

import lombok.NoArgsConstructor;
import org.domain.Artikel;
import org.domain.Product;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
@NoArgsConstructor
public class ArtikelDao extends Dao<Artikel> {

    public List<Artikel> vindAlleBeschikbare() {
        return em.createNamedQuery(printKlasseNaam() + ".vindAlleBeschikbare", T()).getResultList();
    }


}