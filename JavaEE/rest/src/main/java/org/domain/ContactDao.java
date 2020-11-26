package org.domain;

import javax.ejb.Singleton;
import javax.enterprise.inject.Alternative;
import java.util.*;
import java.util.stream.Collectors;

@Alternative
@Singleton
public class ContactDao {
    List<Contact> contacts = new ArrayList<>();

    public ContactDao() {
        this.contacts.add(Contact.builder().id(1L).firstName("Frenkie").surname("Frenkenstijn").email("Frenk@minimuscles.com").build());
        this.contacts.add(Contact.builder().id(2L).firstName("Eddy").surname("Valentijn").email("cupido@valentijn.com").build());
        this.contacts.add(Contact.builder().id(3L).firstName("Rop").surname("Schekmann").email("roppie@hello.com").build());
    }

    public List<Contact> getAll() {
        return this.contacts;
    }

    public void add(Contact c){
        c.setId(calculateId());
        this.contacts.add(c);
        System.out.println(this.contacts.toString());
        System.out.println("Added " + c);
    }

    public void remove(Long  id){
        this.contacts.removeIf(c -> c.getId().equals(id));
    }

    public Contact getById(long id) {
        for (Contact c : this.contacts) {
            if (c.getId() == id)
                return c;
        } return null;
    }

    public boolean update(Long id, Contact contact){
        for (Contact c : this.contacts){
            if (c.getId().equals(id)) {
                this.contacts.set(contacts.indexOf(c), contact);
                return true;
            }
        }return false;
    }

    public long calculateId(){
        Set<Long> ids = this.contacts.stream().map(c -> c.getId()).collect(Collectors.toSet());
        long newId = ids.size();
        while (ids.contains(newId)){
            newId++;
        }
        return newId;
    }
}

