package org.java.training.autumn;

import java.time.LocalDate;
import java.util.Objects;

public final class Person implements Comparable<Person> {
    private final String firstName;
    private final String secondName;
    private final LocalDate birthDate;
    private final int hashCode;

    public Person(PersonDB noteBook){
        this.firstName = noteBook.getFirstName();
        this.secondName = noteBook.getSecondName();
        this.birthDate = noteBook.getBirthDate();
        hashCode = hashCode();
    }

    public String getFirstName(){
        return firstName;
    }

    public String getSecondName(){
        return secondName;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public int compareTo(Person other){
        return secondName.compareTo(other.getFirstName());
    }

    public int hashCode(){
        int prime = 101;
        int out = prime * firstName.hashCode() + secondName.hashCode();
        out = out * prime + birthDate.hashCode();
        return out;
    }


    public boolean equals(Object o){
        if(o==null){return false;}
        if(this.getClass()!=o.getClass()){return false;}
        Person that = (Person) o;
        if(hashCode!=that.hashCode){return false;}
        if(!firstName.equals(that.getFirstName())){return false;}
        if(!secondName.equals(that.getSecondName())){return false;}
        if(!birthDate.equals(that.birthDate)){return false;}
        return true;
    }
}
