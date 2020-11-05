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

    @ElementCollection(fetch = LAZY)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private List<Bezorgwijze> ondersteundeBezorgwijzeLijst = new ArrayList<>();

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE})
    @Builder.Default
    Winkelwagen winkelwagen = new Winkelwagen();

    public Gebruiker() {
    }
}
