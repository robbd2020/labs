package org.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@SuperBuilder
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends Artikel {

    @Setter(value = AccessLevel.NONE)
    @ElementCollection(fetch = EAGER)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    private Set<Bezorgwijze> bezorgwijze = new HashSet<>();

    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE})
    private Winkelwagen winkelwagen;

    public Product() {
    }
}
