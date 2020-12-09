package org.resources;

import org.example.marktplaats2.App;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.shrinkwrap.api.Archive;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URL;

@RunWith(Arquillian.class)
public class MarktplaatsApiIT {

    @ArquillianResource
    private URL deploymentURL;
    private String productenResource;
    private String productenUri = "mp/producten";

    @Before
    public void setup() {
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
    public void wanneerProductIsGepostKanIkHetKrijgen(){
        Client http = ClientBuilder.newClient();
//        Categorie kind = new Categorie("Kinderen");

    }
}
