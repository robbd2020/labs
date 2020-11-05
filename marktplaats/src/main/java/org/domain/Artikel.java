package org.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.util.LocalDateTimeAttribuutconverteerder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@SuperBuilder
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
//@NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select distinct a from Artikel a left join fetch a.categorie b left join fetch b.categorie c left join fetch c.categorie left join fetch a.koper koper left join fetch koper.ondersteundeBezorgwijzeLijst left join fetch koper.winkelwagen left join koper.ondersteundeBezorgwijzeLijst left join fetch a.aanbieder aanbieder left join aanbieder.ondersteundeBezorgwijzeLijst left join fetch aanbieder.winkelwagen left join fetch a.winkelwagen left join a.bezorgwijze where a.koper = null AND a.winkelwagen = null")
@NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select a from Artikel a where a.koper = null AND a.winkelwagen = null")
//@NamedQuery(name = "Artikel.zoekInAlleBeschikbare", query = "select distinct a from Artikel a left join fetch a.categorie b left join fetch b.categorie c left join fetch c.categorie left join fetch a.koper koper left join fetch koper.ondersteundeBezorgwijzeLijst left join fetch koper.winkelwagen left join koper.ondersteundeBezorgwijzeLijst left join fetch a.aanbieder aanbieder left join aanbieder.ondersteundeBezorgwijzeLijst left join fetch aanbieder.winkelwagen left join fetch a.winkelwagen left join a.bezorgwijze where a.koper = null AND a.winkelwagen = null AND (a.naam LIKE ?1 OR a.beschrijving LIKE ?2)")
@NamedQuery(name = "Artikel.zoekInAlleBeschikbare", query = "select a from Artikel a  where a.koper = null AND a.winkelwagen = null AND (a.naam LIKE ?1 OR a.beschrijving LIKE ?2)")

public class Artikel extends AbstracteEntiteit {

    protected String naam;
    protected String beschrijving;
    protected BigDecimal prijs;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Gebruiker aanbieder;

    @Convert(converter = LocalDateTimeAttribuutconverteerder.class)
    @Setter(value = AccessLevel.NONE)
    @Builder.Default
    private LocalDateTime plaatsingsdatum = LocalDateTime.now();

    @ManyToOne
    private Gebruiker koper;

    public Artikel() {
    }

}
