package org.java.training.autumn.list.youtube;

import java.util.Iterator;

public class MyArrayList<E> implements MyArrayListInterface<E>{
    private E[] values;
    public MyArrayList(){
        values = (E[]) new Object();
    }

    @Override
    public E get(int index){
        return values[index];
    }

    @Override
    public int size(){
        return values.length;
    }

    @Override
    public boolean add(E e){
        try{
            E[] temp = values;
            values = (E[]) new Object[temp.length-1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length-1]=e;
            return true;
        }
        catch(ClassCastException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator(){
        return new MyIterator<>(values);
    }

}
