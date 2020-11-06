package org.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Account.vindAccountMetEmailAdresEnWw", query = "SELECT a FROM Account a WHERE a.emailadres = :email AND a.wachtwoord =:wachtwoord")
public abstract class Account extends AbstracteEntiteit{
    String voornaam;
    String achternaam;
    String emailadres;
    String wachtwoord;
    String postcode;
    String woonplaats;
    int huisnummer;
    String huisnummertoevoeging;
    Boolean isActief;

    public Account() {}
}
