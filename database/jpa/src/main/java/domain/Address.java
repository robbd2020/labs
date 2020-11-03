package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@Embeddable
public class Address {
    private String street;
    private Integer housenumber;
    private String zip;
    private String city;

    public Address() {
    }

}
