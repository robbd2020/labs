package domain;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@NamedQuery(name = "Employee.findAll", query = "select emp from Employee emp")
@NamedQuery(name = "Employee.findByName", query = "select emp from Employee emp where emp.name = :name")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int age;


    @Embedded
    private Address address;

    @Lob // CLOB Character large object
    @Basic(fetch = LAZY) // only loaded when explicitly called (with getResume()) on a managed object.
    private String resume;

    @Lob // BLOB Binary large object
    @Basic(fetch = EAGER)
    private byte[] image;


    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private Car car;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Laptop laptop;

    public Employee() {
    }
    public Employee(String name) {
        this(name, -1);
    }

    public Employee(String name, int age) {
        setName(name);
        setAge(age);
    }


    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "" + id + ", " + name + ", " + age;
    }
}
