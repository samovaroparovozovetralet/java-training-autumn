package org.java.training.autumn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Manager extends BasicEmployee{
    private ArrayList<BasicEmployee> assignedEmployees;

    public Manager(Person person, LocalDate employmentDate){
        super(person, employmentDate);
        assignedEmployees = new ArrayList<>();
    }

    public Manager(Person person, LocalDate employmentDate, ArrayList<BasicEmployee> assignedEmployees){
        super(person, employmentDate);
        Objects.requireNonNull(assignedEmployees);
        this.assignedEmployees = new ArrayList<>(assignedEmployees);
    }

    public Manager(Person person, LocalDate employmentDate, BasicEmployee... assignedEmployees){
        super(person, employmentDate);
        Objects.requireNonNull(assignedEmployees);
        this.assignedEmployees = new ArrayList<>(Arrays.asList(assignedEmployees));
    }

    public ArrayList<BasicEmployee> getAssignedEmployees(){
        return assignedEmployees;
    }

    public void assignEmployee(BasicEmployee employee) throws AlreadyAssignedEmployeeException{
        Objects.requireNonNull(employee);
        if(assignedEmployees.contains(employee)){throw new AlreadyAssignedEmployeeException();}
        assignedEmployees.add(employee);
    }

    public void removeAssignedEmployee(BasicEmployee employee){
        assignedEmployees.remove(employee);
    }



}
