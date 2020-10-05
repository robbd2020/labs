package h9;

import h7.Gender;
import h7.PersonDiedException;
import lombok.Builder;

@Builder
public class PersonWithBuilder {

    // -- fields/properties/attributes

    private int age;
    @Builder.Default
    private Gender gender = Gender.UNKNOWN;
    private String name;

    static final int numberOfPossibleGenders = 3;
    static final int MAX_AGE = 130;


    // -- methods

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

    public boolean equals(PersonWithBuilder personToCompare) {
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


