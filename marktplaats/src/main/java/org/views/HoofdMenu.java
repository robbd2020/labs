package org.views;

import org.App;
import org.services.LoginService;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import static java.lang.System.exit;
import static org.views.Printers.*;

public class HoofdMenu {

    public static void start() {
        while (App.getActieveGebruiker()!=null) {
            print(printMenuHeader(MethodHandles.lookup().lookupClass().getSimpleName()));
            print(printOpties(Arrays.asList("Artikelmenu"
                    , "Uitloggen"
                    , "Afsluiten")));

            try {
                switch (App.readLine().toLowerCase()) {
                    case "1":
                        ArtikelMenu.start();
                        break;
                    case "2":
                        LoginService.logUit();
                        break;
                    case "x":
                        print("Tot ziens.");
                        exit(0);
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