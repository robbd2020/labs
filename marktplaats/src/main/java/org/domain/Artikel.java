package org.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@SuperBuilder
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select distinct a from Artikel a left join fetch a.categorie b left join fetch b.categorie c left join fetch c.categorie left join fetch a.koper koper left join fetch koper.ondersteundeBezorgwijzeLijst left join fetch koper.winkelwagen left join koper.ondersteundeBezorgwijzeLijst left join fetch a.aanbieder aanbieder left join aanbieder.ondersteundeBezorgwijzeLijst left join fetch aanbieder.winkelwagen left join fetch a.winkelwagen left join a.bezorgwijze where a.koper = null AND a.winkelwagen = null")
//@NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select a from Artikel a where a.koper = null AND a.winkelwagen = null")
@NamedQuery(name = "Artikel.zoekInAlleBeschikbare", query = "select distinct a from Artikel a left join fetch a.categorie b left join fetch b.categorie c left join fetch c.categorie left join fetch a.koper koper left join fetch koper.ondersteundeBezorgwijzeLijst left join fetch koper.winkelwagen left join koper.ondersteundeBezorgwijzeLijst left join fetch a.aanbieder aanbieder left join aanbieder.ondersteundeBezorgwijzeLijst left join fetch aanbieder.winkelwagen left join fetch a.winkelwagen left join a.bezorgwijze where a.koper = null AND a.winkelwagen = null AND (a.naam LIKE ?1 OR a.beschrijving LIKE ?2)")
//@NamedQuery(name = "Artikel.zoekInAlleBeschikbare", query = "select a from Artikel a  where a.koper = null AND a.winkelwagen = null AND (a.naam LIKE ?1 OR a.beschrijving LIKE ?2)")
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = Product.class)
})
public abstract class Artikel extends AbstracteEntiteit {

    @NotNull
    @Size(max = 50)
    protected String naam;
    @NotNull
    @Size(max = 250)
    protected String beschrijving;
    @NotNull
    @Max(1000)
    protected BigDecimal prijs;

    @NotNull
    @ManyToOne
    protected Categorie categorie;

    @NotNull
    @ManyToOne
    protected Gebruiker aanbieder;

//    @NotNull
////    @Convert(converter = LocalDateTimeAttribuutconverteerder.class)
//    @Setter(value = AccessLevel.NONE)
//    @Builder.Default
//    protected LocalDateTime plaatsingsdatum = LocalDateTime.now();

    @ManyToOne
    protected Gebruiker koper;

    public Artikel() {
    }

}
