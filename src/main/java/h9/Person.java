package h9;

import h7.Gender;
import h7.PersonDiedException;

public class Person {

    // -- fields/properties/attributes

    private int age;
    private Gender gender = Gender.UNKNOWN;
    private String name;

    static final int numberOfPossibleGenders = 3;
    static final int MAX_AGE = 130;

    // -- constructors

    public Person() {
        this("Unknown");
    }

    public Person(String name) {
        this(name, -1);
    }

    public Person(String name, int age) {
        this(name, age, Gender.UNKNOWN);
    }

    public Person(String name, int age, Gender gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    // -- methods

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void haveBirthday() throws PersonDiedException {
        if (this.age >= 130) throw new PersonDiedException("Persoon is overleden");
        this.age++;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender newValue) {
        this.gender = newValue;
    }

    @Override
    public String toString() {
        return getName() + " (" + getAge() + ") is " + getGender();
    }

    public boolean equals(Person personToCompare) {
        return (getAge() == personToCompare.getAge() &&
                getGender() == personToCompare.getGender() &&
                getName().equals(personToCompare.getName()));
    }

    public int hashcode() {
        return getAge() *
                getName().hashCode() *
                getGender().hashCode();
    }

    @Override
    public void finalize() {
        System.out.println("Finalize is aangeroepen!");
    }
}


