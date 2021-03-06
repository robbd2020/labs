package org.example.marktplaats2.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@SuperBuilder
@Entity
@Getter
@NamedNativeQuery(name = "Gebruiker.vindMetWinkelwagen", query = "SELECT * FROM Gebruikers WHERE winkelwagen_id IS :winkelwagen_id")
@NamedQueries({
        @NamedQuery(name = "Gebruiker.vindAlle", query = "SELECT g FROM Gebruiker g")
        ,@NamedQuery(name = "Gebruiker.vindMetGebruikersnaamEnWachtwoord", query = "SELECT g FROM Gebruiker g WHERE g.emailadres = :email AND g.wachtwoord = :wachtwoord ")
})
public class Gebruiker extends Account {

    @ElementCollection(fetch = EAGER)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    @JoinColumn(name = "gebruiker_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Bezorgwijze> ondersteundeBezorgwijzeLijst = new HashSet<>(/*Arrays.asList()*/);

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE})
    @Builder.Default
    private Winkelwagen winkelwagen = new Winkelwagen();

    public Gebruiker() {
        winkelwagen = new Winkelwagen();
    }
}
