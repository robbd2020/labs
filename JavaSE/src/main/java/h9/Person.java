package h9;

import h7.Gender;
import h7.PersonDiedException;
import lombok.Builder;

@Builder //Builder is used, so constructors and setters are removed
public class Person {

    // -- fields/properties/attributes

    private int age;
    @Builder.Default
    private Gender gender = Gender.UNKNOWN;
    private String name;

    static final int numberOfPossibleGenders = 3;
    static final int MAX_AGE = 130;


    // -- methods

    public void setGender(Gender newGender){
        this.gender = newGender;
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

    @Override
    public String toString() {
        return getName() + " (" + getAge() + ") is " + getGender();
    }

    @Override
    public boolean equals(Object personToCompare) {
        if (!(personToCompare instanceof Person)) return false;
        Person p = (h9.Person) personToCompare;
        return (getAge() == p.getAge() &&
                getGender() == p.getGender() &&
                getName().equals(p.getName()));
    }

    @Override
    public int hashCode() {
        return getAge() *
                getName().hashCode() *
                getGender().hashCode();
    }

    @Override
    public void finalize() {
        System.out.println("Finalize is aangeroepen!");
    }
}


