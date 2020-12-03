package org;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import static java.util.Objects.requireNonNull;

//@AllArgsConstructor
@Data
public class Truck extends Vehicle {
    String name;

    public Truck(String name, int age){
        super(age);
        this.name=name;
    }
    @JsonCreator
    public Truck(@JsonProperty("name") final String name) {
        this.name = requireNonNull(name);
    }
}
