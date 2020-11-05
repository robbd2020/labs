package org.views;

import org.App;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import static org.views.Printers.*;

public class HoofdMenu {

    public static void start() {
        while (true) {
            print(printMenuHeader(MethodHandles.lookup().lookupClass().getSimpleName()));
            print(printOpties(Arrays.asList("Artikelen zoeken"
                    , "Afsluiten")));

            try {
                switch (App.readLine().toLowerCase()) {
                    case "1":
                        ArtikelMenu.start();
                        break;
                    case "x":
                        print("Tot ziens.");
                        return;
                    default:
                        print("Ongeldige keuze; probeer opnieuw.");
                        break;
                }
            } catch (NumberFormatException e) {
                print("Dit is ongeldige invoer. Probeer het opnieuw.");
            } catch (RuntimeException t) {
                print("Er ging iets mis... Probeer het opnieuw. ");
//                t.printStackTrace();   MOet nog gaan loggen
                print("Foutmelding: " + t.getMessage());
            } catch (Exception e) {
                print("Er ging iets vreselijk mis... \n\"Foutmelding: " + e.getMessage() + "\nNeem contact op met de leverancier");
            }

        }

    }
}