package org;

import org.dao.ArtikelDao;
import org.dao.CategorieDao;
import org.dao.GebruikerDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class App {

    public static final EntityManager em = Persistence.createEntityManagerFactory("marktplaats").createEntityManager();
    public static final CategorieDao catDao = new CategorieDao(em);
    public static final ArtikelDao artDao = new ArtikelDao(em);
    public static final GebruikerDao gebDao = new GebruikerDao(em);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        VulDatabase.start(catDao, artDao, gebDao);
        new MainMenu().start();
    }

    public static String readLine() {
        return scanner.nextLine();
    }
}
