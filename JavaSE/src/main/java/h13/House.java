package h13;

import h10.Human;

public class House<T extends Human> {
    T inhabitant;

    public House(T inhabitant) {
        this.inhabitant = inhabitant;
    }

    @Override
    public String toString() {
        return "This house is owned by [" + inhabitant.toString() + "] and it says [" + inhabitant.greet() + "]";
    }
}
