package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @GeneratedValue
    @Id
    long id;
    String brand;


    public Car(){}

    public Car(String brand){this.brand = brand;}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }

}
