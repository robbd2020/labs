package org;

import org.dao.ArtikelDao;
import org.dao.CategorieDao;
import org.dao.GebruikerDao;
import org.domain.Artikel;
import org.domain.Categorie;
import org.domain.Gebruiker;
import org.domain.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.domain.Bezorgwijze.*;

public class VulTestDatabase {
    public static void start(CategorieDao catDao, ArtikelDao artDao, GebruikerDao gebDao) {

        Categorie kind = new Categorie("Kinderen");
        Categorie speelgoed = new Categorie("Speelgoed", kind);
        Categorie bal = new Categorie("Bal", speelgoed);
        Categorie minAuto = new Categorie("Miniatuur auto", speelgoed);

        Gebruiker piet = Gebruiker.builder().voornaam("Piet").achternaam("Pietersen").wachtwoord("hoihoipiet").postcode("7777QQ").emailadres("pietje@pietersen.info").huisnummer(100).huisnummertoevoeging("D").woonplaats("Groningen").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, AFHALEN, MAGAZIJN))).isActief(true).build();
        Gebruiker arie = Gebruiker.builder().voornaam("Arie").achternaam("Adriaan").postcode("8888ZZ").emailadres("adriaantje@arie.info").wachtwoord("hoihoiarie").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
        Gebruiker nellie = Gebruiker.builder().voornaam("Nellie").achternaam("Nelson").emailadres("nellie@nelson.info").wachtwoord("hoihoinellie").isActief(true).build();
        gebDao.saveAndDetach(Arrays.asList(piet, arie, nellie));

        Artikel skippybal = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(AFHALEN, VERZENDEN, MAGAZIJN, REMBOURS))).naam("Skippybal").beschrijving("Hier kun je heerlijk op bouncen en je stuitert de kamer rondt").prijs(new BigDecimal("9.50")).categorie(bal).aanbieder(piet).build();
        Artikel skelter = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(AFHALEN, MAGAZIJN))).naam("Skelter").beschrijving("Kun je mee rondcrossen. Trap wel zwaar, goed voor de beenspiertjes!").prijs(new BigDecimal("393.50")).categorie(speelgoed).aanbieder(piet).koper(arie).build();
        Artikel stuiterbal = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(VERZENDEN))).naam("Stuiterbal").beschrijving("Deze bal houdt nooit meer op met stuiteren. Iedereen wordt gek!").prijs(new BigDecimal("0.50")).categorie(bal).aanbieder(piet).build();
        Artikel vwBeetle = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(AFHALEN, MAGAZIJN))).naam("Volkwagen Beetle").beschrijving("Prachtig kevertje, maakt lawaai als je het beweegt. Excl. batterijen").prijs(new BigDecimal("17.95")).categorie(minAuto).aanbieder(piet).build();
        Artikel ferrari = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(MAGAZIJN))).naam("Ferrari F50").beschrijving("Voor de jonge patsers. Dikke pooierbak").prijs(new BigDecimal("89.00")).categorie(minAuto).aanbieder(arie).build();

        List<Categorie> catlijst = Arrays.asList(kind, speelgoed, bal, minAuto);
        List<Artikel> artlijst = Arrays.asList(skippybal, stuiterbal, vwBeetle, ferrari, skelter);

        catDao.saveAndDetach(catlijst);
        artDao.saveAndDetach(artlijst);

    }

    static void drop(CategorieDao catDao, ArtikelDao artDao, GebruikerDao gebDao) {
        App.getWinDao().removeAll();
        App.getArtDao().removeAll();
        App.getCatDao().removeAll();
        App.getGebDao().removeAll();
//        artDao.removeAll();
//        gebDao.removeAll();
//        catDao.removeAll();
    }
}

