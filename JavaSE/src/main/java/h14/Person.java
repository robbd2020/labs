package h14;

import h10.Human;
import h12.MyAnnotation;
import h7.Gender;
import h7.PersonDiedException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@Builder
@MyAnnotation("Person class")
public class Person extends Human {

    // -- fields/properties/attributes

    @Builder.Default
    @Getter
    private int age = -1;
    @Builder.Default
    @Getter
    @Setter
    private Gender gender = Gender.UNKNOWN;
    @Builder.Default
    @Getter
    private String name = "Unknown";

    @Getter
    @Singular("eq")
    private final List<HistoryRecord> historyList = new ArrayList<>();

    static final int numberOfPossibleGenders = 3;
    static final int MAX_AGE = 130;

    // -- inner class
    @MyAnnotation("Person's inner class HistoryRecord")
    class HistoryRecord {
        @Getter
        @Setter
        private String description;

        public HistoryRecord(String desc) {
            setDescription(desc);
        }

        @Override
        public String toString() {
            return getDescription();
        }
    }

    // -- methods

    @MyAnnotation("We're creating history right now")
    public void addHistory(String desc) {
        this.historyList.add(new HistoryRecord(desc));
    }

    public void printHistory() {
        for (HistoryRecord historyRecord : getHistoryList()) {
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

    public void haveBirthday() throws PersonDiedException {
        if (this.age >= 130) throw new PersonDiedException("Persoon is overleden");
        this.age++;
    }

    @Override
    public String toString() {
        return getName() + " (" + getAge() + ") is " + getGender();
    }

    @Override
    public boolean equals(Object personToCompare) {
        if (!(personToCompare instanceof Person)) return false;
        Person p = (Person) personToCompare;
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
    public String greet() {
        return "Hello, my name is " + getName() + ". Nice to meet you!";
    }
}


