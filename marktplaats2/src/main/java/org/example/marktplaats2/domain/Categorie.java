package org.example.marktplaats2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

import static javax.persistence.CascadeType.*;

@Entity
@SuperBuilder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@NamedQuery(name = "Categorie.vindAlle", query = "select c from Categorie c")
public class Categorie extends AbstracteEntiteit {

    @NotNull @Size(max = 30)
    private String categorienaam;
    @JoinColumn(name = "categorie_id")
    @OnDelete(action= OnDeleteAction.CASCADE)
    @OneToOne(cascade = {PERSIST, REMOVE, MERGE})
    private Categorie categorie;

    public Categorie() {
    }

    public Categorie(String catnaam) {
        this.categorienaam = catnaam;
    }
}
