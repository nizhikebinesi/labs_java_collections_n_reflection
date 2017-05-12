package app.collections.humans.iterators;

import app.collections.humans.Human;

import java.util.ListIterator;
import java.util.function.Consumer;

public class ListIteratorByFIO<T extends Human> implements ListIterator<T> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public T previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {

    }

    @Override
    public void add(T t) {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
