package org.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.validation.constraints.*;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Account.vindAccountMetEmailAdresEnWw", query = "SELECT a FROM Account a WHERE a.emailadres = :email AND a.wachtwoord =:wachtwoord")
public abstract class Account extends AbstracteEntiteit{


    private String voornaam;
    @NotNull
    private String achternaam;
    @NotNull @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String emailadres;
    @NotNull @Size(min = 8, max = 50)
    String wachtwoord;
    String postcode;
    String woonplaats;
    int huisnummer;
    String huisnummertoevoeging;
    Boolean isActief;

    public Account() {}
}
