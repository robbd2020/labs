package org.domain;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuperBuilder
@MappedSuperclass
public abstract class AbstracteEntiteit {

    @Id
    @GeneratedValue
    @Getter
    protected long id;

    public AbstracteEntiteit() {
    }
}
