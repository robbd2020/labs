//package org;
//
//import org.dao.*;
//import org.domain.Artikel;
//import org.domain.Gebruiker;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Persistence;
//import javax.validation.ConstraintViolationException;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//
//import static org.App.*;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.domain.Bezorgwijze.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.services.WinkelwagenService.plaatsInWinkelwagen;
//
//class AppIT {
//    public static EntityManager emTest;
//    public static CategorieDao catDaoTest;
//    public static ArtikelDao artDaoTest;
//    public static WinkelwagenDao winDaoTest;
//    public static GebruikerDao gebDaoTest;
//    public static Gebruiker actieveGebruiker;
//
//    @BeforeAll
//    public static void setUp() {
//        emTest = Persistence.createEntityManagerFactory("marktplaats-h2").createEntityManager();
//        catDaoTest = new CategorieDao(emTest);
//        artDaoTest = new ArtikelDao(emTest);
//        gebDaoTest = new GebruikerDao(emTest);
//        winDaoTest = new WinkelwagenDao(emTest);
//    }
//
//    @BeforeEach
//    public void init() {
//        VulTestDatabase.start(catDaoTest, artDaoTest, gebDaoTest);
//        actieveGebruiker = (Gebruiker) gebDaoTest.vindAccountMetEmailEnWw("nellie@nelson.info", "hoihoinellie");
//        App app = new App(emTest, artDaoTest, catDaoTest, gebDaoTest, winDaoTest, actieveGebruiker);
//    }
//
//    @AfterEach
//    public void teardown() {
//        if (getEm().getTransaction().isActive()) {
//            getEm().getTransaction().rollback();
//        }
//        VulTestDatabase.drop();
//
//    }
//
//    @Test
//    void wanneerAlleBeschikbareProductenWordenOpgevraagdWordenDezeVerstrekt() {
//        List<Artikel> artikelLijst = getArtDao().vindAlleBeschikbare();
//        assertThat(artikelLijst.size()).isEqualTo(4);
//    }
//
//    @Test
//    void wanneerErNogGeenProductenInDeWinkelWagenZijnGeplaatsIsWinkelwagenLeeg() {
//        List<Artikel> productenInWinkelwagen = getWinDao().getProductLijst(getActieveGebruiker().getWinkelwagen());
//        assertThat(productenInWinkelwagen.size()).isZero();
//    }
//
//    @Test
//    void wanneerEenNietBestaandProductIDWordtOpgevraagdEntityBestaatNietException() {
//        assertThrows(EntityBestaatNietException.class, () -> getArtDao().getDetachedWithExistenceCheck(300300300300300L));
//    }
//
////    @Test
////    void wanneerEenBestaandProductIDWordtOpgevraagdWordtHetOpgehaald() throws EntityBestaatNietException {
////        Artikel art = null;
////        art = getArtDao().getDetachedWithExistenceCheck(11L);
////        assertThat(art).isNotNull();
////    }
//
//    @Test
//    void actieveGebruikerIsNellie() {
//        assertThat(getActieveGebruiker().getVoornaam()).isEqualTo("Nellie");
//    }
//
//    @Test
//    void wanneerErEenProductInDeWinkelwagenIsGeplaatstIsDezeZichtbaarInDeWinkelwagen() {
//        Artikel a = getArtDao().vindAlleBeschikbare().get(0);
//        plaatsInWinkelwagen(getActieveGebruiker(), a);
//        List<Artikel> productenInWinkelwagen = getWinDao().getProductLijst(getActieveGebruiker().getWinkelwagen());
//        assertThat(productenInWinkelwagen.size()).isEqualTo(1);
//    }
//
//    @Test
//    void wanneerErGeenProductenInDeWinkelWagenZijnGeplaatsIsWinkelwagenLeeg() {
//        List<Artikel> productenInWinkelwagen = getWinDao().getProductLijst(getActieveGebruiker().getWinkelwagen());
//        assertThat(productenInWinkelwagen.size()).isZero();
//    }
//
//    @Test
//    void wanneerGebruikerZonderWachtwoordWordtAangemaaktConstraintViolationException() {
//        Gebruiker henk = Gebruiker.builder().voornaam("Henk").achternaam("De Vries").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
//        assertThrows(ConstraintViolationException.class, ()->getGebDao().saveAndDetach(henk));
//    }
//
//    @Test
//    void wanneerGebruikerMetTeKortWachtwoordWordtAangemaaktConstraintViolationException() {
//        Gebruiker henk = Gebruiker.builder().voornaam("Henk").wachtwoord("hoidoei").achternaam("De Vries").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
////        assertThrows(ConstraintViolationException.class, ()->gebDaoTest.saveAndDetach(henk));
//    }
//
//    @Test
//    void wanneerGebruikerZonderAchternaamWordtAangemaaktConstraintViolationException() {
//        Gebruiker henk = Gebruiker.builder().voornaam("Henk").wachtwoord("hoihoidoei").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
//        assertThrows(ConstraintViolationException.class, () -> getGebDao().saveAndDetach(henk));
//    }
//
//    @Test
//    void wanneerEenGebruikerWordtAangemaaktDieVoldoetAanAlleEisenWordtDezeGepersist(){
//        int gebruikersInDatabase = getGebDao().findAll().size();
//        Gebruiker henk = Gebruiker.builder().voornaam("Henk").achternaam("De Vries").wachtwoord("hoihoidoei").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN,REMBOURS,MAGAZIJN))).isActief(true).build();
//        getGebDao().saveAndDetach(henk);
//        assertEquals(gebruikersInDatabase, getGebDao().findAll().size()-1);
//    }
//}