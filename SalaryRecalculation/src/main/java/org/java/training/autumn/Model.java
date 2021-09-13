package org.java.training.autumn;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Model {
    private ArrayList<Employee> companyEmployees;
    private int budget;

    public Model(int budget){
        this.budget = budget;
        companyEmployees = new ArrayList<>();
    }

    public ArrayList<Employee> getCompanyEmployees(){
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
        addEmployee(new Employee(person, today, salary));
    }

    public void hire(Person person, int salary,
                     ArrayList<Employee> managerAssignedEmployees)
            throws EmployeeAlreadyExistsException{
        LocalDate today = LocalDate.now();
        addEmployee(new Manager(person, today, salary, managerAssignedEmployees));
    }

    public void hire(Person person, int salary, String jobDescription)
            throws EmployeeAlreadyExistsException{
        LocalDate today = LocalDate.now();
        addEmployee(new OtherEmployee(person, today, salary, jobDescription));
    }

    public void remove(Employee employee){
        companyEmployees.remove(employee);
    }

    public void remove(Manager manager){
        // TODO: how to reassign related employees
        companyEmployees.remove(manager);
    }

    public void assignEmployee(Manager manager, Employee employee)
            throws AlreadyConnectedException {
        Objects.requireNonNull(manager);
        manager.getConnectedTo(employee);
    }

    public void removeEmployeeAssignment(Manager manager, Employee employee){
        Objects.requireNonNull(manager);
        manager.getDisconnectedFrom(employee);
    }

    public void transferToNewPosition(Employee employee, int salary){
        remove(employee);
    }

    //utility method
    private void addEmployee(Employee employee)
            throws EmployeeAlreadyExistsException{
        if(companyEmployees.contains(employee)){
            throw new EmployeeAlreadyExistsException();
        }
        companyEmployees.add(employee);
    }

}
