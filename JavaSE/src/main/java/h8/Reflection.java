package h8;

import h9.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        Object person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();
        Method[] methods = person.getClass().getDeclaredMethods();
        String line = "------------------------------";
        System.out.printf("%s\n%30s\n%s\n", line,"Fields",line);
        for (Field field : fields) {
            System.out.printf("%30s\n", field.getName());
        }

        System.out.printf("%s\n%30s\n%s\n", line,"Methods",line);
        for (Method method : methods) {
            System.out.printf("%30s\n", method.getName());
        }
    }
}
