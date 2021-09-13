package org.java.training.autumn.person;

import java.time.LocalDate;
import java.util.Objects;

public enum PersonDB {
    PERSON_ONE("Oleksandr", "Krysynskyi", "1996-19-04"),
    PERSON_TWO("Taras", "Shevchenko", "1814-03-09");

    private final String firstName;
    private final String secondName;
    private final LocalDate birthDate;

    PersonDB(String firstName, String secondName, String birthDate){
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(secondName);
        Objects.requireNonNull(birthDate);
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public String getFirstName(){return firstName;}
    public String getSecondName(){return secondName;}
    public LocalDate getBirthDate(){return birthDate;}

}
