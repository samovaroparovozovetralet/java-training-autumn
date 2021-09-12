package org.java.training.autumn;

import java.time.LocalDate;
import java.util.Objects;

public class OtherEmployee extends BasicEmployee{
    private final String description;

    public OtherEmployee(Person person, LocalDate employmentDate, String description){
        super(person, employmentDate);
        Objects.requireNonNull(description);
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
