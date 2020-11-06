package org.views;

import org.App;
import org.services.LoginService;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import static org.App.actieveGebruiker;
import static org.services.LoginService.*;
import static org.views.Printers.*;
import static org.views.Printers.print;

public class InlogMenu {

    public static void start() {
        while (true) {
            while (actieveGebruiker == null) {
                print(printMenuHeader(MethodHandles.lookup().lookupClass().getSimpleName()));
                print(printOpties(Arrays.asList("Inloggen"
                        , "Afsluiten")));

                try {
                    switch (App.readLine().toLowerCase()) {
                        case "1":
                            print("Typ E-mail addres:");
                            String email = App.readLine();
                            print("Typ Wachtwoord:");
                            String ww = App.readLine();
                            App.actieveGebruiker=logInGebruiker(email, ww);
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
            HoofdMenu.start();
        }
    }
}
