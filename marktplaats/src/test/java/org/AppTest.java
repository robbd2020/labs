package org;

import org.dao.*;
import org.domain.Artikel;
import org.domain.Gebruiker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import java.util.List;

import static org.App.artDao;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.services.WinkelwagenService.plaatsInWinkelwagen;

class AppTest {
    public static EntityManager emTest;
    public static CategorieDao catDaoTest;
    public static ArtikelDao artDaoTest;
    public static WinkelwagenDao winDaoTest;
    public static GebruikerDao gebDaoTest;
    public static Gebruiker actieveGebruiker;

    @BeforeEach
    public void init() {
        emTest = Persistence.createEntityManagerFactory("marktplaats-h2").createEntityManager();
        catDaoTest = new CategorieDao(emTest);
        artDaoTest = new ArtikelDao(emTest);
        gebDaoTest = new GebruikerDao(emTest);
        winDaoTest = new WinkelwagenDao(emTest);
        VulTestDatabase.start(catDaoTest, artDaoTest, gebDaoTest);
        actieveGebruiker = gebDaoTest.getDetached(5L);
        App app = new App(emTest,artDaoTest,catDaoTest,gebDaoTest,winDaoTest,actieveGebruiker);
    }

    @Test
    void wanneerAlleBeschikbareProductenWordenOpgevraagdWordenDezeVerstrekt(){
        List<Artikel> artikelLijst = artDaoTest.vindAlleBeschikbare();
        assertThat(artikelLijst.size()).isEqualTo(4);
    }

    @Test
    void wanneerErNogGeenProductenInDeWinkelWagenZijnGeplaatsIsWinkelwagenLeeg(){
        List<Artikel> productenInWinkelwagen = winDaoTest.getProductLijst(actieveGebruiker.getWinkelwagen());
        assertThat(productenInWinkelwagen.size()).isZero();
    }

    @Test
    void wanneerEenNietBestaandProductIDWordtOpgevraagdEntityBestaatNietException() throws EntityBestaatNietException {
        assertThrows(EntityBestaatNietException.class, ()->artDaoTest.getDetachedWithExistenceCheck(300L));
    }

    @Test
    void wanneerEenBestaandProductIDWordtOpgevraagdWordtHetOpgehaald() throws EntityBestaatNietException {
        Artikel art = null;
        art = artDaoTest.getDetachedWithExistenceCheck(11L);
        assertThat(art).isNotNull();
    }

    @Test
    void actieveGebruikerIsNellie(){
        assertThat(actieveGebruiker.getVoornaam()).isEqualTo("Nellie");
    }

    @Test
    void wanneerErEenProductInDeWinkelwagenIsGeplaatstIsDezeZichtbaarInDeWinkelwagen(){
        Artikel a = artDaoTest.getDetached(11L);
        plaatsInWinkelwagen(actieveGebruiker, a);
        List<Artikel> productenInWinkelwagen = winDaoTest.getProductLijst(actieveGebruiker.getWinkelwagen());
        assertThat(productenInWinkelwagen.size()).isEqualTo(1);
    }

    @Test
    void wanneerErogGeenProductenInDeWinkelWagenZijnGeplaatsIsWinkelwagenLeeg(){
        List<Artikel> productenInWinkelwagen = winDaoTest.getProductLijst(actieveGebruiker.getWinkelwagen());
        assertThat(productenInWinkelwagen.size()).isZero();
    }
}