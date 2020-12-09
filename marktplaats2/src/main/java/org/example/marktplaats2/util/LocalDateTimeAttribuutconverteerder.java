package org.example.marktplaats2.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;

@Converter
public class LocalDateTimeAttribuutconverteerder implements AttributeConverter<LocalDateTime, String> {

    @Override
    public LocalDateTime convertToEntityAttribute(String str) {
        return LocalDateTime.of(Integer.parseInt(str.substring(6)), Integer.parseInt(str.substring(3, 5)), Integer.parseInt(str.substring(0, 2)), 0, 0, 0);
    }

    @Override
    public String convertToDatabaseColumn(LocalDateTime locDateTime) {
        return String.format("%02d", locDateTime.getDayOfMonth()) + "-" + String.format("%02d", locDateTime.getMonthValue()) + "-" + locDateTime.getYear();
    }
}
