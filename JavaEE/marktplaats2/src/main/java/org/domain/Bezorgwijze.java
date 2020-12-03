package org.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

//@JsonDeserialize(using = MyEnumDeserialize.class)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Bezorgwijze {
    AFHALEN, VERZENDEN, MAGAZIJN, REMBOURS;

//    private static Map<String, Bezorgwijze> namesMap = new HashMap<String, Bezorgwijze>(4);
//
//    static {
//        namesMap.put("afhalen", AFHALEN);
//        namesMap.put("verzenden", VERZENDEN);
//        namesMap.put("magazijn", MAGAZIJN);
//        namesMap.put("rembours", REMBOURS);
//    }
//
//    @JsonCreator
//    public static Bezorgwijze forValue(String value) {
//        return namesMap.get(value);
//    }
//
//    @JsonValue
//    public String toValue() {
//        for (Map.Entry<String, Bezorgwijze> entry : namesMap.entrySet()) {
//            if (entry.getValue() == this)
//                return entry.getKey();
//        }
//
//        return null; // or fail
//    }

}
