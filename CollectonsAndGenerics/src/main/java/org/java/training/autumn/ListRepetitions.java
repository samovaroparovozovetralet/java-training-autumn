package org.java.training.autumn;

import java.util.*;
import java.util.stream.Collectors;

public class ListRepetitions {

    public static HashMap<Object, Long> repetitionsMap(ArrayList<Object> source) {
        Objects.requireNonNull(source);
        if (source.isEmpty()) {
            throw new NullPointerException("Source array is empty");
        }

        HashMap<Object, Long> myMap = new HashMap<>();
        for (Object value : source) {
            if(!myMap.containsKey(value)){myMap.put(value, 1L);}
            else{
                myMap.put(value, myMap.get(value) + 1L);
            }
        }
        return myMap;
    }

    public static <T> Map<T,Long> repetitionsMapWithCollectors(List<T> source){
        Objects.requireNonNull(source);
        return source.stream().collect(Collectors.groupingBy(k -> k,
                Collectors.counting()));
    }

    public static <T> Map<T,Long> repetitionsMapWithCompute(List<T> source){
        Map<T, Long> myMap = new HashMap<>();
        source.forEach(e -> myMap.compute(e, (k, v) -> v == null ? 1L : v + 1L));
        return myMap;
    }

}
