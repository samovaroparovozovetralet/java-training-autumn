package org.java.training.autumn;

import java.time.LocalDate;
import java.util.Objects;

public class BasicEmployee {
    private Person person;
    private LocalDate employmentDate;

    public BasicEmployee(Person person, LocalDate employmentDate){
        Objects.requireNonNull(person);
        Objects.requireNonNull(employmentDate);
        this.person = person;
        this.employmentDate = employmentDate;
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

    public boolean equals(Object o){
        return person.equals(o);
    }
}
