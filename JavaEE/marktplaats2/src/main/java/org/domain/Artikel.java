package org.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
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
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@SuperBuilder
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select distinct a from Artikel a left join fetch a.categorie b left join fetch b.categorie c left join fetch c.categorie left join fetch a.koper koper left join fetch koper.ondersteundeBezorgwijzeLijst left join fetch koper.winkelwagen left join koper.ondersteundeBezorgwijzeLijst left join fetch a.aanbieder aanbieder left join aanbieder.ondersteundeBezorgwijzeLijst left join fetch aanbieder.winkelwagen left join fetch a.winkelwagen left join a.bezorgwijze where a.koper = null AND a.winkelwagen = null")
//@NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select a from Artikel a where a.koper = null AND a.winkelwagen = null")
        , @NamedQuery(name = "Artikel.zoekInAlleBeschikbare", query = "select distinct a from Artikel a left join fetch a.categorie b left join fetch b.categorie c left join fetch c.categorie left join fetch a.koper koper left join fetch koper.ondersteundeBezorgwijzeLijst left join fetch koper.winkelwagen left join koper.ondersteundeBezorgwijzeLijst left join fetch a.aanbieder aanbieder left join aanbieder.ondersteundeBezorgwijzeLijst left join fetch aanbieder.winkelwagen left join fetch a.winkelwagen left join a.bezorgwijze where a.koper = null AND a.winkelwagen = null AND (a.naam LIKE ?1 OR a.beschrijving LIKE ?2)")
        , @NamedQuery(name = "Artikel.vindAlle", query = "select distinct a from Artikel a")
//@NamedQuery(name = "Artikel.zoekInAlleBeschikbare", query = "select a from Artikel a  where a.koper = null AND a.winkelwagen = null AND (a.naam LIKE ?1 OR a.beschrijving LIKE ?2)")
})
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

//    @Type(type = "string")
//    @NotNull
//    @Setter(value = AccessLevel.NONE)
//    @Getter(value = AccessLevel.NONE)
//    @Builder.Default
//    @Convert(converter = LocalDateTimeAttribuutconverteerder.class)
//    protected LocalDateTime plaatsingsdatum = LocalDateTime.now();

    @ManyToOne
    protected Gebruiker koper;

    public Artikel() {
    }

    public Artikel(Long id, Gebruiker aanbieder, String beschrijving, Categorie categorie, Gebruiker koper, String naam, BigDecimal prijs)
    { super(id);
    this.id =id;
    this.aanbieder =aanbieder;
    this.beschrijving = beschrijving;
    this.categorie=categorie;
    this.koper=koper;
    this.naam=naam;
    this.prijs=prijs;

    }
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern= "dd-MM-yyyy")
//    public LocalDateTime getPlaatsingsdatum(){
//        return this.plaatsingsdatum;
//    }

}
