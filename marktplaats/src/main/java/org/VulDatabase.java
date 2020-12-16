package org;

import org.domain.Artikel;
import org.domain.Categorie;
import org.domain.Gebruiker;
import org.domain.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.domain.Bezorgwijze.*;

public class VulDatabase {

    public static void main(String[] args) {
        App app = new App();
        start();
    }

    public static void start() {

        Categorie kind = new Categorie("Kinderen");
        Categorie speelgoed = new Categorie("Speelgoed", kind);
        Categorie bal = new Categorie("Bal", speelgoed);
        Categorie minAuto = new Categorie("Miniatuur auto", speelgoed);

        Gebruiker piet = Gebruiker.builder().voornaam("Piet").achternaam("Pietersen").postcode("7777QQ").emailadres("pietje@pietersen.info").wachtwoord("hoihoiarie").huisnummer(100).huisnummertoevoeging("D").woonplaats("Groningen").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, AFHALEN, MAGAZIJN))).isActief(true).build();
        Gebruiker arie = Gebruiker.builder().voornaam("Arie").achternaam("Adriaan").postcode("8888ZZ").emailadres("adriaantje@arie.info").wachtwoord("hoihoipiet").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN))).isActief(true).build();
        Gebruiker nellie = Gebruiker.builder().voornaam("Nellie").achternaam("Nelson").emailadres("nellie@nelson.info").wachtwoord("hoihoinellie").isActief(true).build();
        App.getGebDao().saveAndDetach(Arrays.asList(piet, arie, nellie));

        Artikel skippybal = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(AFHALEN, VERZENDEN, MAGAZIJN, REMBOURS))).naam("Skippybal").beschrijving("Hier kun je heerlijk op bouncen en je stuitert de kamer rond").prijs(new BigDecimal("9.50")).categorie(bal).aanbieder(piet).build();
        Artikel stuiterbal = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(VERZENDEN))).naam("Stuiterbal").beschrijving("Deze bal houdt nooit meer op met stuiteren. Iedereen wordt gek!").prijs(new BigDecimal("0.50")).categorie(bal).aanbieder(piet).build();
        Artikel vwBeetle = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(AFHALEN, MAGAZIJN))).naam("Volkwagen Beetle").beschrijving("Prachtig kevertje, maakt lawaai als je het beweegt. Excl. batterijen").prijs(new BigDecimal("17.95")).categorie(minAuto).aanbieder(piet).build();
        Artikel ferrari = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(MAGAZIJN))).naam("Ferrari F50").beschrijving("Voor de jonge patsers. Dikke pooierbak").prijs(new BigDecimal("89.00")).categorie(minAuto).aanbieder(arie).build();

        List<Categorie> catlijst = Arrays.asList(kind, speelgoed, bal, minAuto);
        List<Artikel> artlijst = Arrays.asList(skippybal, stuiterbal, vwBeetle, ferrari);

        App.getCatDao().saveAndDetach(catlijst);
        App.getArtDao().saveAndDetach(artlijst);

    }

    public static void drop() {
        App.getProDao().removeAll();
        App.getArtDao().removeAll();
        App.getGebDao().removeAll();
        App.getWinDao().removeAll();
        App.getCatDao().removeAll();
        App.getEm().getTransaction().begin();
        App.getEm().createNativeQuery("DELETE FROM id_volgorde").executeUpdate();
        App.getEm().getTransaction().commit();
    }
}



