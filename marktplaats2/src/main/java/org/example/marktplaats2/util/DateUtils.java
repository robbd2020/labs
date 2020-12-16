package org.example.marktplaats2.util;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
    public static final int MAX_LEEFTIJD_ADVERTENTIE_IN_DAGEN = 90;
    public static long TWENTY_THREE_HOURS_IN_MS = 82_800_000;

    public static LocalDate berekenDatumAantalDagenGeleden(int aantalDagen) {
        Date negentigDagenGeledenDate = Date.from(Instant.now().minus(Duration.ofDays(aantalDagen)));
        return convertToLocalDateViaInstant(negentigDagenGeledenDate);
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
