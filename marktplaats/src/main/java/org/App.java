package org;

import org.dao.*;
import org.domain.Gebruiker;
import org.views.InlogMenu;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class App {
    public static EntityManager em;
    public static CategorieDao catDao;
    public static GebruikerDao gebDao;
    public static ArtikelDao artDao;
    public static WinkelwagenDao winDao;
    public static ProductDao proDao;
    private static final Scanner scanner = new Scanner(System.in);
    public static Gebruiker actieveGebruiker = null;

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

    public static void main(String[] args) {
        new App().start();
    }

    public static String readLine() {
        return getScanner().nextLine();
    }

    //Getters en Setters. Lukte niet om dit via Lombok op static fields te laten genereren
    public static EntityManager getEm() {
        return em;
    }

    public static ProductDao getProDao() {
        return proDao;
    }

    public static void setProDao(ProductDao proDao) {
        App.proDao = proDao;
    }

    public static void setEm(EntityManager em) {
        App.em = em;
    }

    public static CategorieDao getCatDao() {
        return catDao;
    }

    public static void setCatDao(CategorieDao catDao) {
        App.catDao = catDao;
    }

    public static GebruikerDao getGebDao() {
        return gebDao;
    }

    public static void setGebDao(GebruikerDao gebDao) {
        App.gebDao = gebDao;
    }

    public static ArtikelDao getArtDao() {
        return artDao;
    }

    public static void setArtDao(ArtikelDao artDao) {
        App.artDao = artDao;
    }

    public static WinkelwagenDao getWinDao() {
        return winDao;
    }

    public static void setWinDao(WinkelwagenDao winDao) {
        App.winDao = winDao;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Gebruiker getActieveGebruiker() {
        return actieveGebruiker;
    }

    public static void setActieveGebruiker(Gebruiker actieveGebruiker) {
        App.actieveGebruiker = actieveGebruiker;
    }
}
