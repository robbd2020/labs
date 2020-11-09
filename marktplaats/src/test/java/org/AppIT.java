package org;

import org.dao.*;
import org.domain.Artikel;
import org.domain.Gebruiker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.domain.Bezorgwijze.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.services.WinkelwagenService.plaatsInWinkelwagen;

class AppIT {
    public static EntityManager emTest;
    public static CategorieDao catDaoTest;
    public static ArtikelDao artDaoTest;
    public static WinkelwagenDao winDaoTest;
    public static GebruikerDao gebDaoTest;
    public static Gebruiker actieveGebruiker;

    @BeforeAll
    public static void setUp() {
    }

    @BeforeEach
    public void init() {
        emTest = Persistence.createEntityManagerFactory("marktplaats-h2").createEntityManager();
        catDaoTest = new CategorieDao(emTest);
        artDaoTest = new ArtikelDao(emTest);
        gebDaoTest = new GebruikerDao(emTest);
        winDaoTest = new WinkelwagenDao(emTest);
        VulTestDatabase.start(catDaoTest, artDaoTest, gebDaoTest);
        actieveGebruiker = (Gebruiker) gebDaoTest.vindAccountMetEmailEnWw("nellie@nelson.info", "hoihoinellie");
        App app = new App(emTest, artDaoTest, catDaoTest, gebDaoTest, winDaoTest, actieveGebruiker);
    }

//    @AfterEach
//    public void tearDown(){
//        VulTestDatabase.drop(catDaoTest, artDaoTest, gebDaoTest);
//    }

    @Test
    void wanneerAlleBeschikbareProductenWordenOpgevraagdWordenDezeVerstrekt() {
        List<Artikel> artikelLijst = app.getArtDao().vindAlleBeschikbare();
        assertThat(artikelLijst.size()).isEqualTo(4);
    }

    @Test
    void wanneerErNogGeenProductenInDeWinkelWagenZijnGeplaatsIsWinkelwagenLeeg() {
        List<Artikel> productenInWinkelwagen = winDaoTest.getProductLijst(actieveGebruiker.getWinkelwagen());
        assertThat(productenInWinkelwagen.size()).isZero();
    }

    @Test
    void wanneerEenNietBestaandProductIDWordtOpgevraagdEntityBestaatNietException() throws EntityBestaatNietException {
        assertThrows(EntityBestaatNietException.class, () -> artDaoTest.getDetachedWithExistenceCheck(300L));
    }

    @Test
    void wanneerEenBestaandProductIDWordtOpgevraagdWordtHetOpgehaald() throws EntityBestaatNietException {
        Artikel art = null;
        art = artDaoTest.getDetachedWithExistenceCheck(11L);
        assertThat(art).isNotNull();
    }

    @Test
    void actieveGebruikerIsNellie() {
        assertThat(actieveGebruiker.getVoornaam()).isEqualTo("Nellie");
    }

    @Test
    void wanneerErEenProductInDeWinkelwagenIsGeplaatstIsDezeZichtbaarInDeWinkelwagen() {
        Artikel a = artDaoTest.getDetached(11L);
        plaatsInWinkelwagen(actieveGebruiker, a);
        List<Artikel> productenInWinkelwagen = winDaoTest.getProductLijst(actieveGebruiker.getWinkelwagen());
        assertThat(productenInWinkelwagen.size()).isEqualTo(1);
    }

    @Test
    void wanneerErGeenProductenInDeWinkelWagenZijnGeplaatsIsWinkelwagenLeeg() {
        List<Artikel> productenInWinkelwagen = winDaoTest.getProductLijst(actieveGebruiker.getWinkelwagen());
        assertThat(productenInWinkelwagen.size()).isZero();
    }

    @Test
    void wanneerGebruikerZonderWachtwoordWordtAangemaaktConstraintViolationException() {
        Gebruiker henk = Gebruiker.builder().voornaam("Henk").achternaam("De Vries").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
//        assertThrows(ConstraintViolationException.class, ()->gebDaoTest.saveAndDetach(henk));
        try {
            gebDaoTest.saveAndDetach(henk);
            fail();
        } catch (ConstraintViolationException e) {
            emTest.getTransaction().rollback();
        }
    }

    @Test
    void wanneerGebruikerMetTeKortWachtwoordWordtAangemaaktConstraintViolationException() {
        Gebruiker henk = Gebruiker.builder().voornaam("Henk").wachtwoord("hoidoei").achternaam("De Vries").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
//        assertThrows(ConstraintViolationException.class, ()->gebDaoTest.saveAndDetach(henk));
    }

    @Test
    void wanneerGebruikerZonderAchternaamWordtAangemaaktConstraintViolationException() {
        Gebruiker henk = Gebruiker.builder().voornaam("Henk").wachtwoord("hoihoidoei").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
        assertThrows(ConstraintViolationException.class, () -> gebDaoTest.saveAndDetach(henk));
    }

//    @Test
//    void wanneerEenGebruikerWordtAangemaaktDieVoldoetAanAlleEisenWordtDezeGepersist(){
//        int gebruikersInDatabase = gebDaoTest.findAll().size();
//        Gebruiker henk = Gebruiker.builder().voornaam("Henk").achternaam("De Vries").wachtwoord("hoihoidoei").postcode("8888ZZ").emailadres("hdv@superwebinfo").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN,REMBOURS,MAGAZIJN))).isActief(true).build();
//        gebDaoTest.saveAndDetach(henk);
//        assertTrue(gebruikersInDatabase == gebDaoTest.findAll().size()-1);
//    }
}