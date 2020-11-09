package org.services;

import org.App;
import org.dao.EntityBestaatNietException;
import org.domain.Artikel;
import org.domain.Gebruiker;
import org.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class WinkelwagenService {

    public static String verwijderUitWinkelwagen(Artikel a) {

        List<Artikel> temp = App.getWinDao().getProductLijst(App.getActieveGebruiker().getWinkelwagen());
        if (temp.contains(a)) {
            verwijderUitWinkelwagen(App.getActieveGebruiker(), a);
            return "Het artikel is verwijderd.";
        } else {
            return "Dit artikel zit niet in uw winkelwagen";
        }
    }

    public static BigDecimal berekenTotaalPrijsWinkelwagen(List<Artikel> pl) {
        return pl.stream().map(Artikel::getPrijs).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static void verwijderUitWinkelwagen(Gebruiker g, Artikel a) {
        if (a instanceof Product)
            verwijderUitWinkelwagen(g, (Product) a);
    }

    public static void verwijderUitWinkelwagen(Gebruiker g, Product p) {
        if (g.getWinkelwagen().getId() == p.getWinkelwagen().getId()) {
            p.setWinkelwagen(null);
            App.getArtDao().updateAndDetach(p);
        }
    }

    public static void plaatsInWinkelwagen(Gebruiker g, Artikel a) {
        if (a instanceof Product)
            plaatsInWinkelwagen(g, (Product) a);
    }

    public static void plaatsInWinkelwagen(Gebruiker g, Product p) {
        p.setWinkelwagen(g.getWinkelwagen());
        App.getArtDao().updateAndDetach(p);
    }

    public static String plaatsInWinkelwagen(Long id) {
        try {
            Artikel a = App.getArtDao().getDetachedWithExistenceCheck(id);
            plaatsInWinkelwagen(App.getActieveGebruiker(), a);
            return ("Het artikel is toegevoegd.");
        } catch (
                EntityBestaatNietException e) {
            return "Dit is geen ID van een beschikbaar product.";
        }
    }

}
