package org.views;

import org.domain.Artikel;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.services.WinkelwagenService.berekenTotaalPrijsWinkelwagen;

public class Printers {

    public static void print(String s){
        System.out.println(s);
    }

    public static String printWinkelwagen(List<Artikel> productLijst) {
        String pl = artikelLijstPrinter(productLijst);
        return String.format("\nInhoud van de winkelwagen:\n%s\nTotaal prijs: %s\n", pl, berekenTotaalPrijsWinkelwagen(productLijst));
    }

    public static String artikelLijstPrinter(List<Artikel> lijst) {
        return lijst.stream().map(Printers::artikelPrinter).collect(joining(tussenLijn(),tussenLijn(),tussenLijn()));

    }

    public static String artikelPrinter(Artikel a) {
        return String.format("Artikelnummer: %s , Naam: %s , Categorie: %s, Aanbieder: %s %s\nBeschrijving: %s\nPrijs: %s", a.getId(), a.getNaam(), a.getCategorie().getCategorienaam(), a.getAanbieder().getVoornaam(), a.getAanbieder().getAchternaam(), a.getBeschrijving(), a.getPrijs());
    }

    public static String printMenuHeader(String titel){
        String vraag = "Wat wilt u doen?";
        return String.format("\n%1$s\n%2$s\n%1$s\n\n%3$s\n", menuLijn(), printTitel(titel),vraag);
    }

    public static String printTitel(String title){
        return title.toUpperCase().replaceAll(".(?=.)", "$0 ");
    }

    public static String tussenLijn(){
        return String.format("\n%s\n", printLijn(119,"-"));
    }

    public static String menuLijn(){
        return printLijn(20, "* - * ");
    }

    public static String printLijn(int multiplicatiefactor, String s){
        return new String(new char[multiplicatiefactor]).replace("\0", s);
    }

    public static String printOpties(List<String> menuopties){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < menuopties.size(); i++){
            s.append(String.format("(%s) [%s]\n", i == menuopties.size() - 1 ? "x" : i + 1, menuopties.get(i)));
        }
        return s.toString();
    }
}
