package org.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Stateless
public class ContactDaoDB {

    @PersistenceContext // Container managed persistence context
    private EntityManager em;

    public List<Contact> getAll() {
        return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }

    public Contact getById(String id) {
        return null;
    }

    public Collection<Contact> get(String q) {
        return null;
    }

    public boolean add(Contact c) {
        return false;
    }

    public boolean remove(String id) {
        return false;
    }

    public boolean update(String id, Contact c) {
        return false;
    }

}
