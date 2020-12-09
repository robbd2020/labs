package org.example.marktplaats2.dao;

public class EntityBestaatNietException extends Exception {
    public EntityBestaatNietException(String bericht) {
        super(bericht);
    }
}
