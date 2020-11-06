package org.services;

import org.domain.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;


import static org.domain.Bezorgwijze.*;
import static org.junit.jupiter.api.Assertions.*;
//import static org.services.ArtikelService.castProductlijstNaarArtikellijst;

class ArtikelServiceTest {
//    @Test
//    void wanneerProductLiistIsGecastNaarArtikellijstBevatDeLijstArtikelen(){
//        Categorie drank = Categorie.builder().categorienaam("Drank").build();
//        Gebruiker aanbieder = Gebruiker.builder().isActief(true)
//                .voornaam("Henk")
//                .achternaam("De Vries")
//                .emailadres("vries@henkweb.nl")
//                .ondersteundeBezorgwijzeLijst(new HashSet<>(Arrays.asList(VERZENDEN, REMBOURS))).build();
//        Product art = Product.builder().aanbieder(aanbieder).naam("Dom perignon").beschrijving("Lekker lekker").categorie(drank).prijs(new BigDecimal("100")).build();
//        Product art1 = Product.builder().aanbieder(aanbieder).naam("Rode wijn shiraz").beschrijving("Erg heftige kater").categorie(drank).prijs(new BigDecimal("6.75")).build();
//
//        List<Artikel> target = castProductlijstNaarArtikellijst(Arrays.asList(art, art1));
//
//        System.out.println(target.get(1).getClass().getTypeName());
////        assertThat(target.forEach(p ->))
//    }
//

}