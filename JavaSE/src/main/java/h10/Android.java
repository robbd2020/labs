package h10;

public class Android extends Human implements Chargeable {

    int level = 50;

    @Override
    public String greet() {
        return "I'm only half human, but human stil... My energy level is " + getLevel() + "%.";
    }

    @Override
    public int charge(int amount) {
        setLevel((getLevel() + amount) <= 100 ? getLevel() + amount : getLevel());
        return getLevel();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
