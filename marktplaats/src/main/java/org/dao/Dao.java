package org.dao;

import org.domain.AbstracteEntiteit;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Dao<T extends AbstracteEntiteit, I extends Number> {

    protected final EntityManager em;

    public Dao(EntityManager em) {
        this.em = em;
    }

    public T get(I id) {
        return em.find(T(), id);
    }

    public T getDetached(I id) {
        T t = em.find(T(), id);
        em.detach(t);
        return t;
    }

    public T getDetachedWithExistenceCheck(I id) throws EntityBestaatNietException {
        T t = em.find(T(), id);
        if (t == null) throw new EntityBestaatNietException("Niets gevonden met ID " + id);
        em.detach(t);
        return t;
    }

//    }

//    public void save(T e) {
//        em.getTransaction().begin();
//        em.persist(e);
//        em.getTransaction().commit();
//    }

    public void saveAndDetach(T item) {
        em.getTransaction().begin();
        em.persist(item);
        detach();
        em.getTransaction().commit();
    }

    public void saveAndDetach(List<T> itemlijst) {
        em.getTransaction().begin();
        itemlijst.forEach(em::persist);
        detach();
        em.getTransaction().commit();
    }

    private void detach() {
        em.flush();
        em.clear();
    }

    public T updateAndDetach(T item) {
//        T managedItem = get(item.getId());
        em.getTransaction().begin();
        T merged = em.merge(item);
//        detach();
        em.getTransaction().commit();
        return merged;
    }



    public void removeAndDetach(T item) {
        em.getTransaction().begin();
        em.remove(item);
        detach();
        em.getTransaction().commit();
    }

    public boolean isManaged(T item) {
        return em.contains(item);
    }

    public List<T> findAll() {
        return em.createQuery("SELECT item FROM " + typeSimple() + " item ", T()).getResultList();
    }

    public List<T> findAllWithNamedQuery() {
        return em.createNamedQuery(typeSimple() + ".findAll", T()).getResultList();
    }

    protected String typeSimple() {
        return T().getSimpleName();
    }

    @SuppressWarnings("unchecked")
    public Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
