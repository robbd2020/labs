package org;

import org.dao.EntityBestaatNietException;
import org.domain.Artikel;
import org.services.ArtikelService;

import static org.App.artDao;
import static org.services.ArtikelService.artikelLijstPrinter;

public class RaadplegenArtikelen {

    public static void start() {
        while (true) {
            System.out.println("*********  Artikel Menu  *********");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Alle artikelen weergeven] ");
            System.out.println("(2) [Artikelen zoeken op basis van een zoekterm]");
            System.out.println("(3) [Artikel in winkelwagen plaatsen]");
            System.out.println("(4) [Artikel uit winkelwagen verwijderen]");
            System.out.println("(x) [Terug naar vorig menu] ");


            switch (App.readLine()) {
                case "1":
                    System.out.print(artikelLijstPrinter(artDao.vindAlleBeschikbare()));
//                    start();
                    break;
                case "2":
                    System.out.println("Typ uw zoekterm: ");
                    System.out.println(artikelLijstPrinter(artDao.zoekInAlleBeschikbare(App.readLine())));
//                    start();
                    break;
                case "3":
                    System.out.println("Typ het id van het product dat u in uw winkelwagen wilt plaatsen: ");
                    try{
                        Artikel a = artDao.getDetachedWithExistenceCheck(Long.parseLong(App.readLine()));
                        if (ArtikelService.plaatsInWinkelwagen(a)) System.out.println("Het artikel is toegevoegd.");
                    } catch(EntityBestaatNietException e){
                        System.out.println("Dit is geen ID van een beschikbaar product.");
                    }

                    break;
                case "x":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }

        }
    }


}

