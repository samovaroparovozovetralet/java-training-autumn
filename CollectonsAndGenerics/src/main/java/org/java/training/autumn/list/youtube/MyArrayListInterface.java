package org.java.training.autumn.list.youtube;

public interface MyArrayListInterface<E> extends Iterable<E>{
    E get(int index);
    int size();
    public boolean add(E e);
}
