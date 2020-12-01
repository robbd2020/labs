package org.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.util.LocalDateTimeAttribuutconverteerder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Artikel extends AbstracteEntiteit {

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

    @NotNull
    @Setter(value = AccessLevel.NONE)
    @Builder.Default
    @Convert(converter = LocalDateTimeAttribuutconverteerder.class)
    protected LocalDateTime plaatsingsdatum = LocalDateTime.now();

    @ManyToOne
    protected Gebruiker koper;

    public Artikel() {
    }

}
