package org.dao;


import org.domain.AbstracteEntiteit;
import org.util.KlassenaamPrinter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.BadRequestException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Dao<E extends AbstracteEntiteit> extends KlassenaamPrinter<E> implements IDaoDB<E>  {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public E getById(long id) {
        E e = em.find(T(), id);
        if (e == null) {
            throw new BadRequestException("Opgegeven id is niet gevonden!");
        }
        return e;
    }

    @Override
    public void insert(E e) {
        em.persist(e);
    }

    public E update(E e) {
        E merged = em.merge(e);
        return merged;
    }

    @Override
    public boolean updateById(long id, E e) {
        E entity = getById(id);
        e.setId(id);
        entity = e;
        em.merge(entity);
        return true;
    }

    @Override
    public void removeById(long id) {
        removeByObject(getById(id));
    }

    public void removeByObject(E e) {
        em.remove(e);
    }

    public List<E> getAll() {
        return em.createQuery("SELECT e FROM " + printKlasseNaam() + " e ", T()).getResultList();
    }

    @Override
    public List<E> getAllWithNamedQuery() {
        return em.createNamedQuery(printKlasseNaam() + ".vindAlle", T()).getResultList();
    }


}
