package org;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Data
public class Vehicles {
    List<Vehicle> vehicles;

    @JsonCreator
    public Vehicles(@JsonProperty("vehicles") final List<Vehicle> vehicles) {
        super();
        this.vehicles = requireNonNull(vehicles);
    }
}