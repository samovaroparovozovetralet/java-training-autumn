package org.java.training.autumn.list.youtube;

import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {
    private int index=0;
    E[] values;
    public MyIterator(E[] values){
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index< values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
