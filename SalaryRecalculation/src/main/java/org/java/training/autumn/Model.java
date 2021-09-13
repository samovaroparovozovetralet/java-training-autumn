package org.java.training.autumn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Model {
    private ArrayList<BasicEmployee> companyEmployees;
    private int budget;

    public Model(int budget){
        this.budget = budget;
        companyEmployees = new ArrayList<>();
    }

    public ArrayList<BasicEmployee> getCompanyEmployees(){
        return companyEmployees;
    }

    public int getBudget(){
        return budget;
    }

    public void setBudget(int budget){
        this.budget = budget;
    }

    public void hire(Person person, int salary)
            throws EmployeeAlreadyExistsException{
        LocalDate today = LocalDate.now();
        addEmployee(new BasicEmployee(person, today, salary));
    }

    public void hire(Person person, int salary,
                     ArrayList<BasicEmployee> managerAssignedEmployees)
            throws EmployeeAlreadyExistsException{
        LocalDate today = LocalDate.now();
        addEmployee(new Manager(person, today, salary, managerAssignedEmployees));
    }

    public void hire(Person person, int salary, String jobDescription)
            throws EmployeeAlreadyExistsException{
        LocalDate today = LocalDate.now();
        addEmployee(new OtherEmployee(person, today, salary, jobDescription));
    }

    public void remove(BasicEmployee employee){
        companyEmployees.remove(employee);
    }

    public void remove(Manager manager){
        // TODO: how to reassign related employees
        companyEmployees.remove(manager);
    }

    public void assignEmployee(Manager manager, BasicEmployee employee)
            throws AlreadyAssignedEmployeeException{
        Objects.requireNonNull(manager);
        manager.removeAssignedEmployee(employee);
    }

    public void removeEmployeeAssignment(Manager manager, BasicEmployee employee){
        Objects.requireNonNull(manager);
        manager.removeAssignedEmployee(employee);
    }

    public void addEmployee(BasicEmployee employee)
            throws EmployeeAlreadyExistsException{
        if(companyEmployees.contains(employee)){
            throw new EmployeeAlreadyExistsException();
        }
        companyEmployees.add(employee);
    }

}
