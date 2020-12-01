package org.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@SuperBuilder
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends Artikel {

    @NotNull
    @Setter(value = AccessLevel.NONE)
    @ElementCollection(fetch = EAGER)
    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    @JoinColumn(name = "product_id")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Set<Bezorgwijze> bezorgwijze = new HashSet<>();
    @ManyToOne(cascade = {PERSIST, MERGE, REMOVE})
    private Winkelwagen winkelwagen;

    public Product() {
    }
}
