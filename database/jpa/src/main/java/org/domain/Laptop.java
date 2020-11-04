package org.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Laptop {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime startDate;

    @Enumerated (value = EnumType.STRING)
    private Brand brand;

    public Laptop(){}

    public Laptop(String name, Brand brand){
        this.name = name;
        this.brand = brand;
        this.startDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }


}
