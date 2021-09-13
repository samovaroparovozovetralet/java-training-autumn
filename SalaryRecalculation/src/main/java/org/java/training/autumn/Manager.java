package org.java.training.autumn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Manager extends BasicEmployee{
    private ArrayList<BasicEmployee> assignedEmployees;

    public Manager(Person person, LocalDate employmentDate, int salary){
        super(person, employmentDate, salary);
        assignedEmployees = new ArrayList<>();
    }

    public Manager(Person person, LocalDate employmentDate, int salary, ArrayList<BasicEmployee> assignedEmployees){
        super(person, employmentDate, salary);
        Objects.requireNonNull(assignedEmployees);
        this.assignedEmployees = new ArrayList<>();

        for(BasicEmployee employee : assignedEmployees){

        }
    }

    public Manager(Person person, LocalDate employmentDate, int salary, BasicEmployee... assignedEmployees){
        super(person, employmentDate, salary);
        Objects.requireNonNull(assignedEmployees);
        this.assignedEmployees = new ArrayList<>();

        for(BasicEmployee employee : assignedEmployees){
            try {
                assignEmployee(employee);
            }
            catch(AlreadyAssignedEmployeeException e){
                e.printStackTrace();
            }
        }
    }

    public ArrayList<BasicEmployee> getAssignedEmployees(){
        return assignedEmployees;
    }

    public void assignEmployee(BasicEmployee employee) throws AlreadyAssignedEmployeeException{
        Objects.requireNonNull(employee);
        if(this.equals(employee)){throw
                new AlreadyAssignedEmployeeException(
                        "Cannot assign Manager to itself", this);}

        if(assignedEmployees.contains(employee)){throw new AlreadyAssignedEmployeeException(
                "Manager already has this employee assigned", employee, this);}
        assignedEmployees.add(employee);
    }

    public void removeAssignedEmployee(BasicEmployee employee){
        assignedEmployees.remove(employee);
    }



}
