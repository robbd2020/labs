package org;

import static org.App.artDao;
import static org.services.ArtikelService.artikelLijstPrinter;

public class RaadplegenArtikelen {

    public void start() {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle artikelen: ");

            System.out.print(artikelLijstPrinter(artDao.vindAlleBeschikbare()));

            System.out.println("Wat wilt u doen?");

            System.out.println("(x) [Terug]");

            switch (App.readLine()) {
                case "x":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }


}

