package h14;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyCollection<T> implements Collection<T> {

    private T[] container = (T[]) new Object[4];

    int positionPointer = 0;

    @Override
    public int size() {
        return getContainer().length;
    }

    @Override
    public boolean isEmpty() {
        return getContainer().length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object o1 : container) {
            if (o1.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<T>() {
            private int index = 1;

            @Override
            public boolean hasNext() {
                return getContainer().length > index;
            }

            @Override
            public T next() {
                return container[index++];
            }
        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        return getContainer();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) Arrays.copyOf(getContainer(), getContainer().length, a.getClass());
    }

    public boolean add(T item) {
        if (getPositionPointer() == getContainer().length) {
            doubleContainerSize();
        }
        getContainer()[getPositionPointer()] = item;
        setPositionPointer(getPositionPointer() + 1);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

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
        this.container = (T[]) newContainer;
    }

    @Override
    public String toString() {
        return Arrays.stream(getContainer()).filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(", "));
    }
}
