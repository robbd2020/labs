package org.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@SuperBuilder
@Entity
@Getter
@NamedNativeQuery(name = "Gebruiker.vindMetWinkelwagen", query = "SELECT * FROM Gebruikers WHERE winkelwagen_id IS :winkelwagen_id")
public class Gebruiker extends Account {

//    @Setter(value = AccessLevel.NONE)

    @ElementCollection(fetch = LAZY)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private List<Bezorgwijze> ondersteundeBezorgwijzeLijst = new ArrayList<>();

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE})
    @Builder.Default
    Winkelwagen winkelwagen = new Winkelwagen();

    @Builder.Default
    @OneToMany(mappedBy = "aanbieder", cascade = PERSIST)
    List<Artikel> artikellijst = new ArrayList<>();

    public Gebruiker() {
    }

    public void biedNieuwArtikelAan(Artikel artikel) {
        this.artikellijst.add(artikel);
        artikel.setAanbieder(this);
    }

    public void haalArtikelUitAanbod(Artikel artikel) {
        this.artikellijst.remove(artikel);
    }

    public void plaatsInWinkelwagen(Product product) {
        product.verplaatsNaarWinkelwagen(getWinkelwagen());
    }

    public void plaatsInWinkelwagen(Artikel artikel) {
        if (artikel instanceof Product)
            plaatsInWinkelwagen((Product) artikel);
    }

    public void verwijderUitWinkelwagen(Artikel artikel){
        if (artikel instanceof Product)
        verwijderUitWinkelwagen((Product) artikel);
    }

    public void verwijderUitWinkelwagen(Product product){
        this.winkelwagen.verwijder(product);
    }
}
