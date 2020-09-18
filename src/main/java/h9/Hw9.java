package h9;

import h7.Gender;
import h7.PersonDiedException;

public class Hw9 {

    class Person {
        private int age;
        private Gender gender = Gender.UNKNOWN;
        private String name;

        static final int numberOfPossibleGenders = 3;
        static final int MAX_AGE = 130;

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
            this.setName(name);
            this.setAge(age);
            this.setGender(gender);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(Gender newValue) {
            this.gender = newValue;
        }

        public Gender getGender() {
            return this.gender;
        }

        public void haveBirthday() throws PersonDiedException {
            if (this.age >= 130) throw new PersonDiedException();
            this.age++;
        }

        public int getAge() {
            return this.age;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.getName() + " (" + this.getAge() + ") is " + this.getGender();
        }

        public boolean equals(Person personToCompare) {
            return (this.getAge() == personToCompare.getAge() &&
                    this.getGender() == personToCompare.getGender() &&
                    this.getName().equals(personToCompare.getName()));
        }
    }

}
