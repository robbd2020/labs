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
@EqualsAndHashCode(callSuper=false)
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Artikel.vindAlleBeschikbare", query = "select a from Artikel a left join fetch a.categorie left join fetch a.koper left join fetch a.aanbieder")
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
