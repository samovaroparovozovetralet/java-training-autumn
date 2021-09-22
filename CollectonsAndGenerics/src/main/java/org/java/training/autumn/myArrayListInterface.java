package org.java.training.autumn;

public interface myArrayListInterface<E> extends Iterable<E>{
    boolean add(E e);
    E get(int index);
    int size();
}
