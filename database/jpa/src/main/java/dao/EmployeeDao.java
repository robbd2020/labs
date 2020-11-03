package dao;

import domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDao extends Dao<Employee>{
    private final Logger log = LoggerFactory.getLogger(EmployeeDao.class);

    public EmployeeDao(EntityManager entityManager) {
        super(Employee.class, entityManager);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
        return query.getResultList();
    }

    public List<Employee> findBy(String name) {
        TypedQuery<Employee> findByNameQuery = em.createNamedQuery("Employee.findByName", Employee.class).setParameter("name", name);
        return findByNameQuery.getResultList();
    }

    public Employee updateName(long id, String name) {
        Employee emp = this.get(id);
        if (emp != null) {
            em.getTransaction().begin();
            emp.setName(name);
            em.getTransaction().commit();
        }
        return emp;
    }


}
