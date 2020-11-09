package org.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@MappedSuperclass
public abstract class AbstracteEntiteit {

    @Id
    @SequenceGenerator(name = "id_volgorde", sequenceName = "id_nummers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_volgorde")

    @Getter
    protected long id;

    public AbstracteEntiteit() {
    }
}
