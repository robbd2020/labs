package h14;

import java.util.HashSet;
import java.util.Set;

public class Group {
    Set<Person> group = new HashSet<>();

    public void add(Person p) {
        this.group.add(p);
    }

    public Set<Person> getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : this.group) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }
}
