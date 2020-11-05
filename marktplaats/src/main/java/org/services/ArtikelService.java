package org.services;

import org.domain.Artikel;

import java.util.List;
import java.util.stream.Collectors;

import static org.App.*;

public class ArtikelService {
    public static String artikelLijstPrinter(List<Artikel> lijst) {
        String s = "\n-------------------------------------------------------------------\n";
        return lijst.stream().map(ArtikelService::artikelPrinter).collect(Collectors.joining(s)).concat(s);

    }

    public static String artikelPrinter(Artikel a) {
        return String.format("Artikelnummer: %s , Naam: %s , Categorie: %s, Aanbieder: %s %s\nBeschrijving: %s\nPrijs: %s", a.getId(), a.getNaam(), a.getCategorie().getCategorienaam(), a.getAanbieder().getVoornaam(), a.getAanbieder().getAchternaam(), a.getBeschrijving(), a.getPrijs());
    }

    public static boolean plaatsInWinkelwagen(Artikel a){
        actieveGebruiker.plaatsInWinkelwagen(a);
        artDao.updateAndDetach(a);
        return true;
    }


}
