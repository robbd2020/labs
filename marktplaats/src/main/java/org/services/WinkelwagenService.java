package org.services;

import org.domain.Artikel;
import org.domain.Gebruiker;
import org.domain.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.App.*;
import static org.App.actieveGebruiker;

public class WinkelwagenService {


    public static String verwijderUitWinkelwagen(Artikel a) {

        List<Artikel> temp = winDao.getProductLijst(actieveGebruiker.getWinkelwagen());
        if (temp.contains(a)) {
            verwijderUitWinkelwagen(actieveGebruiker, a);
            return "Het artikel is verwijderd.";
        } else {
            return "Dit artikel zit niet in uw winkelwagen";
        }
    }

    public static BigDecimal berekenTotaalPrijsWinkelwagen(List<Artikel> pl) {
        return pl.stream().map(p -> p.getPrijs()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static void verwijderUitWinkelwagen(Gebruiker g, Artikel a) {
        if (a instanceof Product)
            verwijderUitWinkelwagen(g, (Product) a);
    }

    public static void verwijderUitWinkelwagen(Gebruiker g, Product p) {
        if (g.getWinkelwagen().getId()==p.getWinkelwagen().getId()) {
            p.setWinkelwagen(null);
            artDao.updateAndDetach(p);
        }
    }

    public static void plaatsInWinkelwagen(Gebruiker g, Artikel a) {
        if (a instanceof Product)
            plaatsInWinkelwagen(g, (Product) a);
    }

    public static void plaatsInWinkelwagen(Gebruiker g, Product p) {
        p.setWinkelwagen(g.getWinkelwagen());
        artDao.updateAndDetach(p);
    }

}
