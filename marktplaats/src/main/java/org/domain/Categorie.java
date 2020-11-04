package org.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@SuperBuilder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class Categorie extends AbstracteEntiteit {

    String categorienaam;

    @OneToOne(cascade = CascadeType.PERSIST)
    Categorie categorie;

    public Categorie() {
    }

    public Categorie(String catnaam) {
        this.categorienaam = catnaam;
    }
}
