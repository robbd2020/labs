package org;

import org.dao.EntityBestaatNietException;
import org.domain.Artikel;
import org.domain.Product;
import org.services.ArtikelService;
import org.services.WinkelwagenService;

import java.util.List;

import static org.App.*;

public class WinkelwagenMenu {
    public static void start() {
        while (true) {
            System.out.println("*********  Winkelwagen Menu  *********");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Alle artikelen in de winkelwagen weergeven] ");
            System.out.println("(2) [Artikel verwijderen uit de winkelwagen]");
//            System.out.println("(3) [Afrekenen]");
            System.out.println("(x) [Terug naar vorig menu] ");

            switch (App.readLine()) {
                case "1":
                    List<Product> productLijst = winDao.getProductLijst(actieveGebruiker.getWinkelwagen());
                    System.out.print(WinkelwagenService.printWinkelwagen(productLijst));

                    break;
                case "2":
                    System.out.println("Typ het artikelnummer van het te verwijderen product: ");
                    try {
                        Artikel a = artDao.getDetachedWithExistenceCheck(Long.parseLong(App.readLine()));
                        List<Product> temp = winDao.getProductLijst(actieveGebruiker.getWinkelwagen());
                        if (temp.contains(a)){
                            System.out.println("Gevonden!");
                            WinkelwagenService.verwijderUitWinkelwagen(a);
                                System.out.println("Het artikel is verwijderd.");
                        }
                        else{
                            System.out.println("Dit artikel zit niet in uw winkelwagen");
                        };
                    } catch (EntityBestaatNietException e) {
                        System.out.println("Dit is geen ID van een beschikbaar product.");
                    }
                    break;
                case "3":
                    System.out.println("Typ het id van het product dat u in uw winkelwagen wilt plaatsen: ");
                    try {
                        Artikel a = artDao.getDetachedWithExistenceCheck(Long.parseLong(App.readLine()));
                        if (ArtikelService.plaatsInWinkelwagen(a)) System.out.println("Het artikel is toegevoegd.");
                    } catch (EntityBestaatNietException e) {
                        System.out.println("Dit is geen ID van een beschikbaar product.");
                    }
                case "4":
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }

        }
    }

}
