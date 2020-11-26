package org;

import lombok.Getter;
import lombok.Setter;
import org.dao.*;
import org.domain.Gebruiker;
import org.views.InlogMenu;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class App {
    @Getter @Setter
    private static EntityManager em;
    @Getter @Setter
    private static CategorieDao catDao;
    @Getter @Setter
    private static GebruikerDao gebDao;
    @Getter @Setter
    private static ArtikelDao artDao;
    @Getter @Setter
    private static WinkelwagenDao winDao;
    @Getter @Setter
    private static ProductDao proDao;
    @Getter
    private static final Scanner scanner = new Scanner(System.in);
    @Getter @Setter
    private static Gebruiker actieveGebruiker = null;

    public App() {
        setEm(Persistence.createEntityManagerFactory("marktplaats").createEntityManager());
        setCatDao(new CategorieDao(em));
        setGebDao(new GebruikerDao(em));
        setArtDao(new ArtikelDao(em));
        setWinDao(new WinkelwagenDao(em));
        setProDao(new ProductDao(em));
//        actieveGebruiker = gebDao.getDetached(5L);
    }

    public App(EntityManager em, ArtikelDao artDao, CategorieDao catDao, GebruikerDao gebDao, WinkelwagenDao winDao, Gebruiker actieveGebruiker) {
        setEm(em);
        setArtDao(artDao);
        setCatDao(catDao);
        setGebDao(gebDao);
        setWinDao(winDao);
        setProDao(new ProductDao(em));
        setActieveGebruiker(actieveGebruiker);
    }

    public void start() {
        InlogMenu.start();
    }


    public static String readLine() {
        return getScanner().nextLine();
    }


}
