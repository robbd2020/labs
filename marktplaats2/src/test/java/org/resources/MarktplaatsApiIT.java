package org.resources;

import org.example.marktplaats2.App;
import org.example.marktplaats2.domain.Categorie;
import org.example.marktplaats2.domain.Gebruiker;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.jboss.shrinkwrap.api.Archive;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.example.marktplaats2.domain.Bezorgwijze.VERZENDEN;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class MarktplaatsApiIT {

    @ArquillianResource
    private URL deploymentURL;
    private String productenResource;
    private String productenUri = "resources/producten";
    private String categorieResource;
    private String categorieUri = "resources/categorieen";
    private String gebruikerResource;
    private String gebruikerUri = "resources/gebruikers";

    @Before
    public void setup() {
        categorieResource = deploymentURL + categorieUri;
        productenResource = deploymentURL + productenUri;
    }

    @Deployment
    public static Archive<?> createDeployment(){
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "ProductResourceIT.war")
                .addPackages(true, App.class.getPackage()) // dont forget!
                .addAsWebInfResource("test-beans.xml", "beans.xml")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");

        System.out.println(archive.toString(true));
        return archive;
    }

    @Test
    public void wanneerCategorieIsGepostKanHetWordenVerkregen(){
        Client http = ClientBuilder.newClient();
        Categorie drank = new Categorie("Drank");

        String postedContact = http
                .target(categorieResource)
                .request().post(entity(drank, APPLICATION_JSON), String.class);


        String alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertThat(alleCategorieen, containsString("categorienaam\":\"Drank"));
    }

//    @Rule
//    public ExpectedException thrown = ExpectedException.none();
//    @Test (expected = BadRequestException.class)
//    public void wanneerCategorieIsGepostKanHetWordenVerwijderd(){
//        thrown.expect(BadRequestException.class);
//
//        Client http = ClientBuilder.newClient();
//        Categorie autos = new Categorie("Autos");
//
//
//        Categorie postedCategorie = http
//                .target(categorieResource)
//                .request().post(entity(autos, APPLICATION_JSON), Categorie.class);
//
//
//        System.out.println(postedCategorie);
//
//        http
//                .target(categorieResource+"/"+postedCategorie.getId())
//                .request().delete();
//
//        Categorie verwijderdeCategorie = http
//                .target(categorieResource+"/"+postedCategorie.getId())
//                .request().get(Categorie.class);
//
//        System.out.println(verwijderdeCategorie);
////        assertThat(alleCategorieen, containsString("categorienaam\":\"Drank"));
//    }

    @Test
    public void wanneerCategorieIsGepostKanHetWordenVerwijderd(){

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
                .target(categorieResource+"/"+postedCategorie.getId())
                .request().delete();

        alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertFalse(alleCategorieen.contains("categorienaam\":\"Autos"));

    }

    @Test
    public void wanneerCategorieIsGepostKanHetWordenAangepast(){

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
                .target(categorieResource+"/"+postedCategorie.getId())
                .request().put(entity(postedCategorie, APPLICATION_JSON), Categorie.class);

        alleCategorieen = http
                .target(categorieResource)
                .request().get(String.class);

        assertFalse(alleCategorieen.contains("categorienaam\":\"Autos"));
        assertTrue(alleCategorieen.contains("categorienaam\":\"Wagens"));

    }

    @Test
    public void wanneerGebruikerIsGepostKanHetWordenVerkregen(){
        Client http = ClientBuilder.newClient();
        Gebruiker misterX = Gebruiker.builder().voornaam("Mr").achternaam("X").emailadres("mr@x.info").wachtwoord("xxx").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN))).build();

        String postedGebruiker = http
                .target(gebruikerResource)
                .request().post(entity(misterX, APPLICATION_JSON), String.class);


        String alleGebruikers = http
                .target(categorieResource)
                .request().get(String.class);

        assertThat(alleGebruikers, containsString("categorienaam\":\"Drank"));
    }

}
