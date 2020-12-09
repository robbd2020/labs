package org.example.marktplaats2.dao;

import lombok.NoArgsConstructor;
import org.example.marktplaats2.domain.Artikel;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
@NoArgsConstructor
public class ArtikelDao extends Dao<Artikel> {

    public List<Artikel> vindAlleBeschikbare() {
        return em.createNamedQuery(printKlasseNaam() + ".vindAlleBeschikbare", T()).getResultList();
    }

}