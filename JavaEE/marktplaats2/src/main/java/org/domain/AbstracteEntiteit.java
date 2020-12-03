package org.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public abstract class AbstracteEntiteit {

    @Id
    @SequenceGenerator(name = "id_volgorde", sequenceName = "id_nummers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_volgorde")

    protected Long id;


}