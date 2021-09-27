package org.java.training.autumn.employee;

import org.java.training.autumn.exceptions.AlreadyConnectedException;
import org.java.training.autumn.person.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Employee implements Connectable, IPayee, Comparable<Employee> {
    private Person person;
    private LocalDate employmentDate;
    private int salary;
    private ArrayList<Connectable> connectedTo;

    public Employee(Person person, LocalDate employmentDate, int salary){
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

    public int compareTo(Employee other){
        return person.compareTo(other.getPerson());
    }

    public ArrayList<Connectable> getConnections(){
        return connectedTo;
    }

    public void connectTo(Connectable item)throws AlreadyConnectedException {
        Objects.requireNonNull(item);
        if(this.equals(item)){throw
                new AlreadyConnectedException(
                        "Cannot assign item to itself", this);}

        if(connectedTo.contains(item)){throw new AlreadyConnectedException(
                "Connection already exists", item, this);}
        connectedTo.add(item);
    }

    public void disconnectFrom(Connectable owner){
        connectedTo.remove(owner);
    }
}
