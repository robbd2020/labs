package org.example.marktplaats2.service;

import org.example.marktplaats2.cleaning.BerichtProducent;
import org.example.marktplaats2.dao.ProductDao;
import org.example.marktplaats2.domain.Product;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

import static org.example.marktplaats2.util.DateUtils.berekenDatumAantalDagenGeleden;

public  class SchoonmaakSet {

    @Inject
    private ProductDao dao;

    @Inject
    private BerichtProducent producer;

    public void verwijderProductenMetLeeftijdInDagen(int leeftijdInDagen) {
        System.out.println(this.dao);
        LocalDate oudsteArtikelDatum = berekenDatumAantalDagenGeleden(leeftijdInDagen);
        List<Product> productLijst = dao.vindAlleBeschikbare();
        productLijst.stream().filter(product ->
                product.getPlaatsingsdatum().isBefore(oudsteArtikelDatum))
                .forEach(product -> producer.stuurProductVerwijderBericht(product.getId()));
    }

    public void verwijderIndividueelProduct(long productId){
        dao.removeById(productId);
    }
}
