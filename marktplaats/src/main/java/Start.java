import org.domain.Artikel;
import org.domain.Categorie;
import org.domain.Gebruiker;
import org.domain.Product;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

import static org.domain.Bezorgwijze.*;
import static org.domain.Bezorgwijze.AFHALEN;

public class Start {
    public static void main(String[] args) {
        Categorie kind = new Categorie("Kinderen");
        Categorie speelgoed = new Categorie("Speelgoed", kind);
        Categorie bal = new Categorie("Bal", speelgoed);
        Categorie minAuto = new Categorie("Miniatuur auto", speelgoed);

        Gebruiker piet = Gebruiker.builder().voornaam("Piet").achternaam("Pietersen").postcode("7777QQ").emailadres("pietje@pietersen.info").huisnummer(100).huisnummertoevoeging("D").woonplaats("Groningen").ondersteundeBezorgwijzeLijst(Arrays.asList(VERZENDEN, REMBOURS, AFHALEN, MAGAZIJN)).isActief(true).build();
        Gebruiker arie = Gebruiker.builder().voornaam("Arie").achternaam("Adriaan").postcode("8888ZZ").emailadres("adriaantje@arie.info").huisnummer(32).woonplaats("Beek").ondersteundeBezorgwijzeLijst(Arrays.asList(VERZENDEN, REMBOURS, MAGAZIJN)).isActief(true).build();
        Gebruiker nellie = Gebruiker.builder().voornaam("Nellie").achternaam("Nelson").emailadres("nellie@nelson.info").isActief(true).build();

        Artikel skippybal = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(AFHALEN, VERZENDEN, MAGAZIJN, REMBOURS))).naam("Skippybal").beschrijving("Hier kun je heerlijk op bouncen").prijs(new BigDecimal("9.50")).categorie(bal).aanbieder(piet).build();
        Artikel stuiterbal = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(VERZENDEN))).naam("Stuiterbal").beschrijving("Deze bal houdt nooit meer op met stuiteren. Iedereen wordt gek!").prijs(new BigDecimal("0.50")).categorie(bal).aanbieder(piet).build();
        Artikel vwBeetle = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(AFHALEN, MAGAZIJN))).naam("Volkwagen Beetle").beschrijving("Prachtig kevertje, maakt lawaai als je het beweegt. Excl. batterijen").prijs(new BigDecimal("17.95")).categorie(minAuto).aanbieder(piet).build();
        Artikel ferrari = Product.builder().bezorgwijze(new HashSet<>(Arrays.asList(MAGAZIJN))).naam("Ferrari F50").beschrijving("Voor de jonge patsers. Dikke pooierbak").prijs(new BigDecimal("89.00")).categorie(minAuto).aanbieder(arie).build();

        String zoekterm = "yoyo";
        System.out.println("'%".concat(zoekterm).concat("%'"));

    }


}
