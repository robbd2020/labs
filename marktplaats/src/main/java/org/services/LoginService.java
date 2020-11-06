package org.services;

import org.dao.GebruikerDao;
import org.domain.Account;
import org.domain.Gebruiker;

import static org.App.gebDao;

public class LoginService {
    public static Gebruiker logInGebruiker(String email, String ww){
        Account account = gebDao.vindAccountMetEmailEnWw(email, ww);
        return account instanceof Gebruiker ? (Gebruiker) account : null;
    }

}