package org;

import org.dao.ArtikelDao;
import org.dao.CategorieDao;
import org.dao.GebruikerDao;
import org.dao.WinkelwagenDao;
import org.domain.Gebruiker;
import org.views.HoofdMenu;
import org.views.InlogMenu;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class App {

    public static EntityManager em;
    public static CategorieDao catDao;
    public static GebruikerDao gebDao;
    public static ArtikelDao artDao;
    public static WinkelwagenDao winDao;
    private static Scanner scanner = new Scanner(System.in);
    public static Gebruiker actieveGebruiker = null;

    public App() {
        em = Persistence.createEntityManagerFactory("marktplaats").createEntityManager();
        catDao = new CategorieDao(em);
        gebDao = new GebruikerDao(em);
        artDao = new ArtikelDao(em);
        winDao = new WinkelwagenDao(em);
//        actieveGebruiker = gebDao.getDetached(5L);
    }

    public App(EntityManager em, ArtikelDao artDao, CategorieDao catDao, GebruikerDao gebDao, WinkelwagenDao winDao, Gebruiker actieveGebruiker){
        this.em=em;
        this.artDao=artDao;
        this.catDao=catDao;
        this.gebDao=gebDao;
        this.winDao =winDao;
        this.actieveGebruiker=actieveGebruiker;
    }

    public void start() {
//        VulDatabase.start(catDao, artDao, gebDao);
        InlogMenu.start();
    }

    public static void main(String[] args) {
        new App().start();

    }

    public static String readLine() {
        return scanner.nextLine();
    }
}
