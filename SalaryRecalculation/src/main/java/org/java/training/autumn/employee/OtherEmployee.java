package org.java.training.autumn.employee;

import org.java.training.autumn.person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class OtherEmployee extends Employee{
    private final String description;

    public OtherEmployee(Person person, LocalDate employmentDate, int salary, String description){
        super(person, employmentDate, salary);
        Objects.requireNonNull(description);
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
