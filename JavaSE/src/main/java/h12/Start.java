package h12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Start {
    public static void main(String[] args) {
    Class<Person> personClass = Person.class;
    Annotation[] annotations = personClass.getAnnotations();

        System.out.println("Class annotations:");
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println("Inner class annotations:");
        for (Class<?> aClass : personClass.getDeclaredClasses()) {
            for (Annotation annotation : aClass.getAnnotations()) {
                System.out.println(annotation);
            }
        }

        System.out.println("Method annotations:");
        for (Method declaredMethod : personClass.getDeclaredMethods()) {
            for (Annotation annotation : declaredMethod.getAnnotations()) {
                System.out.println(declaredMethod.getName()+ ": " + annotation);
            }
        }

    }
}
