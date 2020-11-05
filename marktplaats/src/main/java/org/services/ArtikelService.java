package org.services;

import org.domain.Artikel;
import org.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

import static org.App.actieveGebruiker;
import static org.App.winDao;

public class ArtikelService {

    public static List<Artikel> castProductlijstNaarArtikellijst(List<Product> productLijst) {
        return productLijst.stream().map(p -> (Artikel) p).collect(Collectors.toList());
    }



}
