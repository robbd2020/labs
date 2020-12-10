package org.example.marktplaats2.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import lombok.Getter;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstracteEntiteit {

    @Id
    @SequenceGenerator(name = "id_volgorde", sequenceName = "id_nummers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_volgorde")

    protected Long id;


}