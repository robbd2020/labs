package org.example.marktplaats2;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class test {
    public static LocalDate berekenDatumNegentigDagenGeleden(String[] args) {
        Date negentigDagenGeledenDate = Date.from(Instant.now().minus(Duration.ofDays(90)));
        return convertToLocalDateViaInstant(negentigDagenGeledenDate);
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
