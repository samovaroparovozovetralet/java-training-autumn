package org.java.training.autumn.samples.student;

public class Student {
    private String name;
    private int age;
    private String group;
    private static final int hashPrime = 101;

    public Student(String name, int age, String group){
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student stud = (Student) o;

        if(name !=stud.name){return false;}
        if(group!=stud.group){return false;}
        return true;
    }

    @Override
    public int hashCode(){
        int nameHash = name.hashCode();
        int groupHash = group.hashCode();

        return hashPrime * nameHash + groupHash;
    }
}
