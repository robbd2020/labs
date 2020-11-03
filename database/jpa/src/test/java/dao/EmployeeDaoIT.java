package dao;

import domain.Employee;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoIT {
    private EntityManager em = Persistence
            .createEntityManagerFactory("H2")
            .createEntityManager();

    private EmployeeDao target = new EmployeeDao(em);

    @Test
    void whenEmployeeIsInsertedThenItHasAnId(){
        target.insert(new Employee("Roberto"));
        Employee employee = target.get(1L);

        assertEquals(1, employee.getId());
    }

    @Test
    void whenEmployeeIsGottenResumeIsLazilyLoaded() {
        // given a new and saved employee
        Employee e = new Employee("emp");
        e.setResume("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent non tempus enim. Duis eget sapien enim. Morbi elementum dictum tempus. Sed posuere tortor mauris, quis vehicula tellus congue non.");
        target.saveAndDetach(e);

        // when we get it from the db and it is detached
        Employee detachedEmp = target.get(e.getId());
        em.clear(); // detach
        // then resume is not loaded and cannot be loaded anymore
        assertFalse(em.contains(detachedEmp));
        assertThrows(LazyInitializationException.class, detachedEmp::getResume);

        // but
        // when we keep it managed
        Employee managedEmp = target.get(e.getId());
        // then the resume can be loaded
        assertTrue(em.contains(managedEmp));
        String resume = managedEmp.getResume(); // get resume from managed employee
        assertFalse(resume.isEmpty()); // this should succeed
    }
}
