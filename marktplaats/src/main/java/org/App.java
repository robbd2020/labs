package org;

import org.dao.ArtikelDao;
import org.dao.CategorieDao;
import org.dao.GebruikerDao;
import org.dao.WinkelwagenDao;
import org.domain.Gebruiker;
import org.views.HoofdMenu;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class App {

    public static final EntityManager em = Persistence.createEntityManagerFactory("marktplaats").createEntityManager();
    public static final CategorieDao catDao = new CategorieDao(em);
    public static final ArtikelDao artDao = new ArtikelDao(em);
    public static final GebruikerDao gebDao = new GebruikerDao(em);
    public static final WinkelwagenDao winDao = new WinkelwagenDao(em);
    private static final Scanner scanner = new Scanner(System.in);
    public static final Gebruiker actieveGebruiker = gebDao.getDetached(5L);

    public static void main(String[] args) {
//        VulDatabase.start(catDao, artDao, gebDao);
        HoofdMenu.start();
    }

    public static String readLine() {
        return scanner.nextLine();
    }
}
