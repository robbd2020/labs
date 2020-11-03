import dao.Dao;
import dao.EmployeeDao;
import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
//        LocalDateTime locDateTime = LocalDateTime.of(1987, 9, 29, 0, 0, 0);
//        System.out.println(String.format("%02d", locDateTime.getDayOfMonth()));
//
//        String st = String.format("%02d", locDateTime.getDayOfMonth()) + "-" + String.format("%02d", locDateTime.getMonthValue()) + "-" + locDateTime.getYear();
//        System.out.println(st);
//
//        String str = st;
//        System.out.println(LocalDateTime.of(Integer.parseInt(str.substring(6)), Integer.parseInt(str.substring(3, 5)), Integer.parseInt(str.substring(0, 2)), 0, 0, 0));

        EntityManager em = Persistence.createEntityManagerFactory("MySQLjpademo").createEntityManager();



        EmployeeDao eDao = new EmployeeDao(em);
        List<Employee> employeeList = new ArrayList<>();
        Employee e = new Employee("Pietje", 33);
        employeeList.add(e);
        employeeList.add(new Employee("Klaasje", 98));
        employeeList.add(new Employee("Jantje", 104));

        eDao.insert(employeeList);


        e.assignLaptop(new Laptop("Supermachine", Brand.ASUS));
        eDao.update(e);
        Employee employee = eDao.get(2);
        System.out.println(employee);
        System.out.println(eDao.findBy("Klaas"));

        Employee empie = eDao.update(eDao.get(2));
        empie.setAddress(Address.builder().city("Laren").housenumber(10).street("Dorpsstraat1").build());
        eDao.update(empie);
        empie.setCar(new Car("Hyundai"));
        eDao.update(empie);

    }
}
