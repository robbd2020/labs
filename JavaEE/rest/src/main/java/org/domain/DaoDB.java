package org.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.BadRequestException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class DaoDB<E extends AbstractEntity> implements IDaoDB<E> { // E: type of entity; I: type of id of entity

    @PersistenceContext
    private EntityManager em;

    @Override
    public E getById(long id) {
        E e = em.find(E(), id);
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
        return em.createQuery("SELECT e FROM " + typeSimple() + " e ", E()).getResultList();
    }

    @Override
    public List<E> getAllWithNamedQuery() {
        return em.createNamedQuery(typeSimple() + ".findAll", E()).getResultList();
    }

    private String typeSimple() {
        return E().getSimpleName();
    }

    /**
     * @return a class instance of the first generic type parameter (E) of this Dao,
     * e.g. for EmployeeDao<Employee, Long>, it returns Employee.class.
     */
    @SuppressWarnings("unchecked")
    private Class<E> E() {
        ParameterizedType thisDaoClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<E>) thisDaoClass.getActualTypeArguments()[0];
    }

}
