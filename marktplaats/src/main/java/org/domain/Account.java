package org.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account extends AbstracteEntiteit{
    String voornaam;
    String achternaam;
    String emailadres;
    String postcode;
    String woonplaats;
    int huisnummer;
    String huisnummertoevoeging;
    Boolean isActief;

    public Account() {}
}
