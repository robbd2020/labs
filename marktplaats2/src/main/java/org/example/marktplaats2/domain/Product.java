package org.example.marktplaats2.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@SuperBuilder
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Product.vindAlle", query = "select p from Product p")
        , @NamedQuery(name = "Product.vindAlleBeschikbare", query = "select p from Product p where p.koper is null and p.winkelwagen is null")
        , @NamedQuery(name = "Product.zoekInAlleBeschikbare", query = "select distinct p from Product p where p.koper is null AND p.winkelwagen is null AND (p.naam LIKE ?1 OR p.beschrijving LIKE ?2)")
})
public class Product extends Artikel {

    @NotNull
    @ElementCollection(fetch = EAGER)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    @JoinColumn(name = "product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Bezorgwijze> bezorgwijze = new HashSet<>(/*Arrays.asList(Bezorgwijze.VERZENDEN)*/);

    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE})
    private Winkelwagen winkelwagen;

}
