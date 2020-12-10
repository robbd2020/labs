package org.example.marktplaats2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {
    private String email;
    private String wachtwoord;
}
