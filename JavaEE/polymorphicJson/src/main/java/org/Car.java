package org;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import static java.util.Objects.requireNonNull;

@Data
public class Car extends Vehicle {
    String name;



    @JsonCreator
    public Car(@JsonProperty("name") final String name) {
        this.name = requireNonNull(name);
    }
}