package org.example.marktplaats2;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class App extends Application {}


//
//public class App {
//    @Getter @Setter
//    private static EntityManager em;
//    @Getter @Setter
//    private static CategorieDao catDao;
//    @Getter @Setter
//    private static GebruikerDao gebDao;
//    @Getter @Setter
//    private static ArtikelDao artDao;
//    @Getter @Setter
//    private static WinkelwagenDao winDao;
//    @Getter @Setter
//    private static ProductDao proDao;
//    @Getter
//    private static final Scanner scanner = new Scanner(System.in);
//    @Getter @Setter
//    private static Gebruiker actieveGebruiker = null;
//
//    public App() {
//        setEm(Persistence.createEntityManagerFactory("marktplaats2").createEntityManager());
//        setCatDao(new CategorieDao(em));
//        setGebDao(new GebruikerDao(em));
//        setArtDao(new ArtikelDao(em));
//        setWinDao(new WinkelwagenDao(em));
//        setProDao(new ProductDao(em));
////        actieveGebruiker = gebDao.getDetached(5L);
//    }
//
//    public App(EntityManager em, ArtikelDao artDao, CategorieDao catDao, GebruikerDao gebDao, WinkelwagenDao winDao, Gebruiker actieveGebruiker) {
//        setEm(em);
//        setArtDao(artDao);
//        setCatDao(catDao);
//        setGebDao(gebDao);
//        setWinDao(winDao);
//        setProDao(new ProductDao(em));
//        setActieveGebruiker(actieveGebruiker);
//    }
//
//    public void start() {
//        InlogMenu.start();
//    }
//
//
//    public static String readLine() {
//        return getScanner().nextLine();
//    }
//
//
//}
