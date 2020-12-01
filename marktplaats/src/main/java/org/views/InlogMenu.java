package org.views;

import org.App;

import javax.persistence.NoResultException;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import static org.services.LoginService.logInGebruiker;
import static org.util.Printers.*;

public class InlogMenu implements Boundary {

    public static void start() {
        while (true) {
            while (App.getActieveGebruiker() == null) {
                print(printMenuHeader(MethodHandles.lookup().lookupClass().getSimpleName()));
                print(printOpties(Arrays.asList("Inloggen"
                        , "Afsluiten")));

                try {
                    switch (App.readLine().toLowerCase()) {
                        case "1":
                            print("Typ e-mail addres:");
                            String email = App.readLine();
                            print("Typ wachtwoord:");
                            String ww = App.readLine();
                            App.setActieveGebruiker(logInGebruiker(email, ww));
                            HoofdMenu.start();
                            break;
                        case "x":
                            print("Tot ziens.");
                            return;
                        default:
                            print("Ongeldige keuze; probeer opnieuw.");
                            break;
                    }
                } catch (NoResultException e){
                    print("Geen geldige combinatie");
                }
                catch (NumberFormatException e) {
                    print("Dit is ongeldige invoer. Probeer het opnieuw.");

                } catch (RuntimeException t) {
                    print("Er ging iets mis... Probeer het opnieuw. ");
                    t.printStackTrace();  // MOet nog gaan loggen
                    print("Foutmelding: " + t.getMessage());
                } catch (Exception e) {
                    print("Er ging iets vreselijk mis... \n\"Foutmelding: " + e.getMessage() + "\nNeem contact op met de leverancier");
                }

            }
            HoofdMenu.start();
        }
    }
}
