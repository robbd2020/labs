package org.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@SuperBuilder
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends Artikel {

    @Setter(value = AccessLevel.NONE)
    @ElementCollection(fetch = EAGER)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private List<Bezorgwijze> bezorgwijze = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Winkelwagen winkelwagen;


    public Product() {
    }

    public void verplaatsNaarWinkelwagen(Winkelwagen winkelwagen) {
        setWinkelwagen(winkelwagen);
        winkelwagen.plaats(this);
    }

    public void verwijderUitWinkelwagen() {
        this.winkelwagen.verwijder(this);
        setWinkelwagen(null);
    }

}
