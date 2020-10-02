package h13;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyCollection<T> {


    Object[] container = new Object[4];

    int positionPointer = 0;

    public void add(T item) {
        if (getPositionPointer() == getContainer().length) {
            doubleContainerSize();
        }
        getContainer()[getPositionPointer()] = item;
        setPositionPointer(getPositionPointer() + 1);
    }

    public void doubleContainerSize() {
        Object[] container2 = new Object[getContainer().length * 2];
        for (int i = 0; i < getPositionPointer(); i++) {
            container2[i] = getContainer()[i];
        }
        setContainer(container2);
    }

    public Object[] getContainer() {
        return this.container;
    }

    public int getPositionPointer() {
        return positionPointer;
    }

    public void setPositionPointer(int positionPointer) {
        this.positionPointer = positionPointer;
    }

    public void setContainer(Object[] newContainer) {
        this.container = newContainer;
    }

    @Override
    public String toString() {
        return Arrays.stream(getContainer()).filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(", "));
    }
}
