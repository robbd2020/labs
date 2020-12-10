package org.resources;

import org.example.marktplaats2.App;
import org.example.marktplaats2.domain.Categorie;
import org.example.marktplaats2.domain.Gebruiker;
import org.example.marktplaats2.domain.Login;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.example.marktplaats2.domain.Bezorgwijze.VERZENDEN;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MarktplaatsApiIT {

    @ArquillianResource
    private URL deploymentURL;
    private String productenResource;
    private String productenUri = "resources/producten";
    private String categorieResource;
    private String categorieUri = "resources/categorieen";
    private String gebruikersResource;
    private String gebruikerUri = "resources/gebruikers";
    private String loginResource;
    private String loginUri = "resources/login";

    @Before
    public void setup() {
        categorieResource = deploymentURL + categorieUri;
        productenResource = deploymentURL + productenUri;
        gebruikersResource = deploymentURL + gebruikerUri;
        loginResource = deploymentURL + loginUri;
    }

    @Deployment
    public static Archive<?> createDeployment() {
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "ProductResourceIT.war")
                .addPackages(true, App.class.getPackage()) // dont forget!
                .addAsWebInfResource("test-beans.xml", "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");

        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void wanneerCategorieIsGepostKanHetWordenVerkregen() {
        Client http = ClientBuilder.newClient();
        Categorie drank = new Categorie("Drank");

        http
                .target(categorieResource)
                .request().post(entity(drank, APPLICATION_JSON), String.class);

        String alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertThat(alleCategorieen, containsString("categorienaam\":\"Drank"));
    }

    @Test
    public void wanneerNietBestaandeCategorieWordtOpgevraagdIsDeResponsStatus400() {

        Client http = ClientBuilder.newClient();

        Response response = http
                .target(categorieResource + "/" + 987654321)
                .request().get();

        assertThat(response.getStatus(), is(400));
    }

    @Test
    public void wanneerCategorieIsGepostKanHetWordenVerwijderd() {

        Client http = ClientBuilder.newClient();
        Categorie autos = new Categorie("Autos");

        Categorie postedCategorie = http
                .target(categorieResource)
                .request().post(entity(autos, APPLICATION_JSON), Categorie.class);

        String alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertThat(alleCategorieen, containsString("categorienaam\":\"Autos"));

        http
                .target(categorieResource + "/" + postedCategorie.getId())
                .request().delete();

        alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertFalse(alleCategorieen.contains("categorienaam\":\"Autos"));

    }

    @Test
    public void wanneerCategorieIsGepostKanHetWordenAangepast() {

        Client http = ClientBuilder.newClient();
        Categorie autos = new Categorie("Autos");

        Categorie postedCategorie = http
                .target(categorieResource)
                .request().post(entity(autos, APPLICATION_JSON), Categorie.class);

        String alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertThat(alleCategorieen, containsString("categorienaam\":\"Autos"));

        postedCategorie.setCategorienaam("Wagens");
        http
                .target(categorieResource + "/" + postedCategorie.getId())
                .request().put(entity(postedCategorie, APPLICATION_JSON), Categorie.class);

        alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertFalse(alleCategorieen.contains("categorienaam\":\"Autos"));
        assertTrue(alleCategorieen.contains("categorienaam\":\"Wagens"));

    }

    @Test
    public void wanneerGebruikerIsGepostKanHetWordenVerkregen() {
        Client http = ClientBuilder.newClient();
        Gebruiker misterX = Gebruiker.builder().voornaam("Mr").achternaam("X").emailadres("mr@mrx.info").wachtwoord("xxxxxxxxx").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN))).build();

        http
                .target(gebruikersResource)
                .request().post(entity(misterX, APPLICATION_JSON), Gebruiker.class);

        String alleGebruikers = http
                .target(gebruikersResource)
                .request().get(String.class);

        assertThat(alleGebruikers, containsString("voornaam\":\"Mr"));
        assertThat(alleGebruikers, containsString("achternaam\":\"X"));
        assertThat(alleGebruikers, containsString("emailadres\":\"mr@mrx.info"));
    }

    @Test
    public void wanneerGebruikerIsGepostKanHetWordenVerwijderd() {
        Client http = ClientBuilder.newClient();
        Gebruiker misterX = Gebruiker.builder().voornaam("Mr").achternaam("X").emailadres("mr@bladiebla.info").wachtwoord("xxxxxxxxx").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN))).build();

        Gebruiker postedGebruiker = http
                .target(gebruikersResource)
                .request().post(entity(misterX, APPLICATION_JSON), Gebruiker.class);

        String alleGebruikers = http
                .target(gebruikersResource)
                .request().get(String.class);

        assertThat(alleGebruikers, containsString("emailadres\":\"mr@bladiebla.info"));

        http
                .target(gebruikersResource + "/" + postedGebruiker.getId())
                .request().delete();

        alleGebruikers = http
                .target(gebruikersResource)
                .request().get(String.class);

        assertFalse(alleGebruikers.contains("emailadres\":\"mr@bladiebla.info"));

    }

    @Test
    public void wanneerGebruikerIsGepostKanHetWordenAangepast() {
        Client http = ClientBuilder.newClient();
        Gebruiker misterX = Gebruiker.builder().voornaam("Mr").achternaam("Naaktgeboren").emailadres("mr@testuser.info").wachtwoord("xxxxxxxxx").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN))).build();

        Gebruiker postedGebruiker = http
                .target(gebruikersResource)
                .request().post(entity(misterX, APPLICATION_JSON), Gebruiker.class);

        String alleGebruikers = http
                .target(gebruikersResource)
                .request().get(String.class);

        assertThat(alleGebruikers, containsString("emailadres\":\"mr@testuser.info"));
        assertThat(alleGebruikers, containsString("achternaam\":\"Naaktgeboren"));

        postedGebruiker.setAchternaam("Kluivert");
        http
                .target(gebruikersResource + "/" + postedGebruiker.getId())
                .request().put(entity(postedGebruiker, APPLICATION_JSON));

        alleGebruikers = http
                .target(gebruikersResource)
                .request().get(String.class);

        assertFalse(alleGebruikers.contains("achternaam\":\"Naaktgeboren"));
        assertTrue(alleGebruikers.contains("achternaam\":\"Kluivert"));

    }

    @Test
    public void wanneerGebruikerIsAangemaaktKanDezeInloggen() {
        Client http = ClientBuilder.newClient();
        Gebruiker misterX = Gebruiker.builder().voornaam("Mr").achternaam("Naaktgeboren").emailadres("mr@naaktgeboren.info").wachtwoord("xxxxxxxxx").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN))).build();

        Gebruiker postedGebruiker = http
                .target(gebruikersResource)
                .request().post(entity(misterX, APPLICATION_JSON), Gebruiker.class);

        String alleGebruikers = http
                .target(gebruikersResource)
                .request().get(String.class);

        assertThat(alleGebruikers, containsString("emailadres\":\"mr@naaktgeboren.info"));

        Login login = Login.builder().email("mr@naaktgeboren.info").wachtwoord("xxxxxxxxx").build();
        Gebruiker target = http.target(loginResource).request().post(entity(login, APPLICATION_JSON), Gebruiker.class);

        assertEquals(target, postedGebruiker);

    }


}
