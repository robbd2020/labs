package org.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement // necessary for sending xml response
@Entity
@NamedQuery(name = "Contact.findAll", query = "select c from Contact c")
public class Contact {
    @Id
    Long id;
    String firstName;
    String surname;
    String email;
}
