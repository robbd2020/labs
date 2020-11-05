package org.services;

import org.domain.Artikel;
import org.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.App.actieveGebruiker;
import static org.App.artDao;

public class WinkelwagenService {

    public static String printWinkelwagen(List<Product> productLijst){
        String pl = ArtikelService.artikelLijstPrinter(castProductlijstNaarArtikellijst(productLijst));
        return String.format("%s\nTotaal prijs: %s\n", pl, berekenTotaalPrijsWinkelwagen(productLijst));
    }

    public static List<Artikel> castProductlijstNaarArtikellijst(List<Product> productLijst) {
        return productLijst.stream().map(p -> (Artikel) p).collect(Collectors.toList());
    }

    public static BigDecimal berekenTotaalPrijsWinkelwagen(List<Product> pl){
        return pl.stream().map(p -> p.getPrijs()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static void verwijderUitWinkelwagen(Artikel a){
        actieveGebruiker.verwijderUitWinkelwagen(a);
        artDao.updateAndDetach(a);
    }

}
