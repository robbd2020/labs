package org.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Bezorgwijze> bezorgwijze = new HashSet<>();

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
