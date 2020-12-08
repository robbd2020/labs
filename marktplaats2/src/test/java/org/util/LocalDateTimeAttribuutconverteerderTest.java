//package org.util;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class LocalDateTimeAttribuutconverteerderTest {
//
//    LocalDateTimeAttribuutconverteerder conv;
//
//    @BeforeEach
//    public void init(){
//    conv = new LocalDateTimeAttribuutconverteerder();
//    }
//
//    @Test
//    void whenStringDateIsConvertedToLocalDateDayIsConverted() {
//        String datum = "29-02-2000";
//        LocalDateTime target = conv.convertToEntityAttribute(datum);
//        assertThat(target.getDayOfMonth()).isEqualTo(29);
//    }
//
//    @Test
//    void whenStringDateIsConvertedToLocalDateMonthIsConverted() {
//        String datum = "02-08-1992";
//        LocalDateTime target = conv.convertToEntityAttribute(datum);
//        assertThat(target.getMonthValue()).isEqualTo(8);
//    }
//
//    @Test
//    void whenStringDateIsConvertedToLocalDateYearIsConverted() {
//        String datum = "02-08-1992";
//        LocalDateTime target = conv.convertToEntityAttribute(datum);
//        assertThat(target.getYear()).isEqualTo(1992);
//    }
//
//    @Test
//    void whenLocalDateTimeIsConvertedToStringDayAndMonthBelow10ContainExtraZero() {
//        LocalDateTime datum = LocalDateTime.of(1989, 2, 1, 1, 1);
//        String target = conv.convertToDatabaseColumn(datum);
//        assertThat(target).isEqualTo("01-02-1989");
//    }
//
//    @Test
//    void whenLocalDateTimeIsConvertedToStringAndBackResultIsTheSame(){
//        LocalDateTime datum = LocalDateTime.of(1989, 2, 1,0, 0);
//        String stringDatum = conv.convertToDatabaseColumn(datum);
//        LocalDateTime target = conv.convertToEntityAttribute(stringDatum);
//        assertThat(target).isEqualTo(datum);
//    }
//
//    @Test
//    void whenStringIsConvertedToLocalDateTimeAndBackResultIsTheSame(){
//        String datum ="29-02-2004";
//        LocalDateTime ldtdatum = conv.convertToEntityAttribute(datum);
//        String target = conv.convertToDatabaseColumn(ldtdatum);
//        assertThat(target).isEqualTo(datum);
//    }
//
//}