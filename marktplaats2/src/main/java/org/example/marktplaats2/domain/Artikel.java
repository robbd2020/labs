package org.example.marktplaats2.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@SuperBuilder
@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select a from Artikel a where a.koper is null"),
        @NamedQuery(name = "Artikel.vindAlle", query = "select distinct a from Artikel a")
})
public abstract class Artikel extends AbstracteEntiteit {

    @NotNull
    @Size(max = 50)
    protected String naam;
    @NotNull
    @Size(max = 250)
    protected String beschrijving;
    @NotNull
    @Max(2500)
    protected BigDecimal prijs;

    @NotNull
    @ManyToOne
    protected Categorie categorie;

    @NotNull
    @ManyToOne
    protected Gebruiker aanbieder;

    @Builder.Default
    @NotNull
    protected LocalDate plaatsingsdatum = LocalDate.now();

    @ManyToOne
    protected Gebruiker koper;
}
