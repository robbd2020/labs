package org.views;

import org.App;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import static org.services.WinkelwagenService.plaatsInWinkelwagen;
import static org.util.Printers.*;

public class ArtikelMenu implements Boundary{

    public static void start() {
        while (true) {
            print(printMenuHeader(MethodHandles.lookup().lookupClass().getSimpleName()));
            print(printOpties(Arrays.asList("Alle artikelen weergeven"
                    , "Artikelen zoeken op basis van een zoekterm"
                    , "Artikelen in winkelwagen plaatsen"
                    , "Winkelwagen beheren"
                    , "Terug naar het hoofdmenu")));

            switch (App.readLine()) {
                case "1":
                    print(String.format("\nArtikeloverzicht:\n%s", artikelLijstPrinter(App.getArtDao().vindAlleBeschikbare())));
                    break;
                case "2":
                    print("Typ uw zoekterm: ");
                    String input = App.readLine();
                    print(String.format("\nArtikeloverzicht van artikelen die voldoen aan %s:\n%s", input,artikelLijstPrinter(App.getArtDao().zoekInAlleBeschikbare(input))));
                    break;
                case "3":
                    print("Typ het id van het product dat u in uw winkelwagen wilt plaatsen: ");
                    print(plaatsInWinkelwagen(Long.parseLong(App.readLine())));
                    break;
                case "4":
                    WinkelwagenMenu.start();
                    break;
                case "x":
                    return;
                default:
                    print("Ongeldige keuze; probeer opnieuw.");
            }

        }
    }

}

