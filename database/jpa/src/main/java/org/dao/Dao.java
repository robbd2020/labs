package org.dao;

import org.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class Dao<T> {
    EntityManager em;
    public Class<T> entityClass;
    private final Logger log = LoggerFactory.getLogger(Dao.class);


    public Dao(Class<T> entityClass, EntityManager entityManager) {
        this.em = entityManager;
        this.entityClass = entityClass;
    }

    public void insert(T e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void insert(List<T> eList) {
        em.getTransaction().begin();
        eList.forEach(e -> {
            em.persist(e);
            log.debug("Persist " + e.toString());
        });

        em.getTransaction().commit();
    }

//     public List<T> findAll() {
//        TypedQuery<T> query = em.createNamedQuery("Employee.findAll", Employee.class);
//        return query.getResultList();
//    }

//    public List<Employee> findBy(String name) {
//        TypedQuery<Employee> findByNameQuery = em.createNamedQuery("Employee.findByName", Employee.class).setParameter("name", name);
//        ;
//        return findByNameQuery.getResultList();
//    }

    public void saveAndDetach(T e) {
        em.getTransaction().begin();
        em.persist(e);
        detach();
        em.getTransaction().commit();
    }

    private void detach() {
        em.flush();
        em.clear();
    }


    public T update(T e) {
        em.getTransaction().begin();
        T updatedItem = em.merge(e);
        em.getTransaction().commit();
        return updatedItem;
    }

    public T get(long id) { return em.find(entityClass, id);}
//
//    public Employee updateName(long id, String name) {
//        Employee emp = this.get(id);
//        if (emp != null) {
//            em.getTransaction().begin();
//            emp.setName(name);
//            em.getTransaction().commit();
//        }
//        return emp;
//    }

    public void remove(Employee employee) {
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();

    }
}
