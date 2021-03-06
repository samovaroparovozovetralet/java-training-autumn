package org.java.training.autumn.employee;

import org.java.training.autumn.exceptions.AlreadyConnectedException;
import org.java.training.autumn.person.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Manager extends Employee{
    private ArrayList<Connectable> assignedEmployees;

    public Manager(Person person, LocalDate employmentDate, int salary){
        super(person, employmentDate, salary);
        assignedEmployees = new ArrayList<>();
    }

    public Manager(Person person, LocalDate employmentDate, int salary, ArrayList<Employee> assignedEmployees){
        super(person, employmentDate, salary);
        Objects.requireNonNull(assignedEmployees);
        this.assignedEmployees = new ArrayList<>();

        for(Employee employee : assignedEmployees){
            try {
                connectTo(employee);
            }
            catch(AlreadyConnectedException e){
                e.printStackTrace();
            }
        }
    }

    public Manager(Person person, LocalDate employmentDate, int salary, Employee... assignedEmployees){
        super(person, employmentDate, salary);
        Objects.requireNonNull(assignedEmployees);
        this.assignedEmployees = new ArrayList<>();

        for(Employee employee : assignedEmployees){
            try {
                connectTo(employee);
            }
            catch(AlreadyConnectedException e){
                e.printStackTrace();
            }
        }
    }

}
