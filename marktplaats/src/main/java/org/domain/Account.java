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


    protected String voornaam;
    @NotNull
    protected String achternaam;
    @NotNull @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    protected String emailadres;
    @NotNull @Size(min = 8, max = 50)
    protected String wachtwoord;
    protected String postcode;
    protected String woonplaats;
    protected int huisnummer;
    protected String huisnummertoevoeging;
    protected Boolean isActief;

    public Account() {}
}
