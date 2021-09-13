package org.java.training.autumn;

import java.time.LocalDate;
import java.util.Objects;

public class BasicEmployee {
    private Person person;
    private LocalDate employmentDate;
    private int salary;

    public BasicEmployee(Person person, LocalDate employmentDate, int salary){
        Objects.requireNonNull(person);
        Objects.requireNonNull(employmentDate);
        this.person = person;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public String getFirstName(){
        return person.getFirstName();
    }

    public String getSecondName(){
        return person.getSecondName();
    }

    public LocalDate getBirthDate(){
        return person.getBirthDate();
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public boolean equals(Object o){
        return person.equals(o);
    }

    public int hashCode(){
        return person.hashCode();
    }
}
