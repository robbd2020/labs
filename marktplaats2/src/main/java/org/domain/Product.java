package org.domain;

//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonSubTypes;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
//import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;
import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
//@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
//@JsonSubTypes({
////            @JsonSubTypes.Type(value = Product.class)
//})
@SuperBuilder
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Product.vindAlle", query = "select p from Product p")
public class Product extends Artikel {


    @NotNull
    @ElementCollection(fetch = EAGER)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    @JoinColumn(name = "product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Bezorgwijze> bezorgwijze = new HashSet<>(Arrays.asList(Bezorgwijze.VERZENDEN));
    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE})
    private Winkelwagen winkelwagen;

    public Product() {
    }

//    @JsonCreator
//    public Product(
//
//            @JsonProperty("id") Long id,
//            @JsonProperty("gebruiker") Gebruiker aanbieder,
//            @JsonProperty("beschrijving") String beschrijving,
//            @JsonProperty("categorie") Categorie categorie,
//            Gebruiker koper,
//            String naam,
//            BigDecimal prijs,
//            Set<Bezorgwijze> bezorgwijze,
//            Winkelwagen winkelwagen
//    ) {
//        super(id, aanbieder, beschrijving, categorie, koper, naam, prijs);
//        this.bezorgwijze = bezorgwijze;
//        this.winkelwagen = winkelwagen;
//    }
}
