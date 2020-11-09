package org.services;

import org.App;
import org.domain.Account;
import org.domain.Gebruiker;

import static org.App.setActieveGebruiker;

public class LoginService {
    public static Gebruiker logInGebruiker(String email, String ww){
        Account account = App.getGebDao().vindAccountMetEmailEnWw(email, ww);
        return account instanceof Gebruiker ? (Gebruiker) account : null;
    }

    public static void logUit(){
        setActieveGebruiker(null);
    }

}
