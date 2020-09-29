package h12;

import h10.Human;
import h7.Gender;
import h7.PersonDiedException;

@MyAnnotation("Greatest class ever seen")
public class Person extends Human {

    // -- fields/properties/attributes

    private int age;
    private Gender gender = Gender.UNKNOWN;
    private String name;
    private HistoryRecord[] historyArray = new HistoryRecord[10];
    private int positionInhistoryArray = 0;

    static final int numberOfPossibleGenders = 3;
    static final int MAX_AGE = 130;

    // -- inner class
    @MyAnnotation("The greatest in history")
    class HistoryRecord {
        private String description;

        public HistoryRecord(String desc) {
            setDescription(desc);
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return getDescription();
        }
    }

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

    @MyAnnotation("Make it great again!")
    public void addHistory(String description) {
        if (getPositionInhistoryArray() < getHistoryArray().length) {
            getHistoryArray()[getPositionInhistoryArray()] = new HistoryRecord(description);
            this.positionInhistoryArray++;
        }
    }

    public void printHistory() {
        for (HistoryRecord historyRecord : getHistoryArray()) {
            if (historyRecord != null) System.out.println(historyRecord);
        }
    }

    public Human createSubHuman() {
        return new Human() {
            @Override
            public String greet() {
                return "Sub is the best.";
            }
        };
    }

    public HistoryRecord[] getHistoryArray() {
        return historyArray;
    }

    public void setHistoryArray(HistoryRecord[] historyArray) {
        this.historyArray = historyArray;
    }

    public int getPositionInhistoryArray() {
        return positionInhistoryArray;
    }

    public void setPositionInhistoryArray(int positionInhistoryArray) {
        this.positionInhistoryArray = positionInhistoryArray;
    }

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

    public boolean equals(h10.Person personToCompare) {
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
    public String greet() {
        return "Hello, my name is " + getName() + ". Nice to meet you!";
    }
}


