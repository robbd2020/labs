package org.views;

import org.App;
import org.dao.EntityBestaatNietException;
import org.domain.Artikel;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;

import static org.services.WinkelwagenService.verwijderUitWinkelwagen;
import static org.util.Printers.*;

public class WinkelwagenMenu implements Boundary {
    public static void start() {
        while (true) {
            print(printMenuHeader(MethodHandles.lookup().lookupClass().getSimpleName()));
            print(printOpties(Arrays.asList("Alle artikelen in de winkelwagen weergeven"
            ,"Artikel verwijderen uit de winkelwagen"
//            ,"Afrekenen"
            ,"Terug naar artikel menu")));

            switch (App.readLine()) {
                case "1":
                    List<Artikel> productLijst = App.getWinDao().getProductLijst(App.getActieveGebruiker().getWinkelwagen());
                    print(printWinkelwagen(productLijst));
                    break;
                case "2":
                    print("Typ het artikelnummer van het te verwijderen product: ");
                    try {
                        Artikel a = App.getArtDao().getDetachedWithExistenceCheck(Long.parseLong(App.readLine()));
                        print(verwijderUitWinkelwagen(a));
                    } catch (EntityBestaatNietException e) {
                        print("Dit is geen ID van een beschikbaar product.");
                    }
                    break;
                case "x":
                    return;
                default:
                    print("Ongeldige keuze; probeer opnieuw.");
            }

        }
    }

}
