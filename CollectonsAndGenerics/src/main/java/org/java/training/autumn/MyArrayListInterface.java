package org.java.training.autumn;

public interface MyArrayListInterface<E> extends Iterable<E>{
    E get(int index);
    int size();
    public boolean add(E e);
}
