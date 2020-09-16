package Hw7;

class Person {
    private int age;
    private Gender gender = Gender.UNKNOWN;
    private String name;

    static final int numberOfPossibleGenders = 3;
    static final int MAX_AGE = 130;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
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

}

