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
        for(Connectable connection : employee.getConnections()){
            connection.getDisconnectedFrom(employee);
        }
        companyEmployees.remove(employee);
    }

    public void remove(Manager manager){
        // TODO: whom to reassign related employees
        for(Connectable connection : manager.getConnections()){
            connection.getDisconnectedFrom(manager);
        }
        companyEmployees.remove(manager);
    }

    public void assignEmployee(Manager manager, Employee employee)
            throws AlreadyConnectedException {
        Objects.requireNonNull(manager);
        manager.getConnectedTo(employee);
        employee.getConnectedTo(manager);
    }

    public void removeEmployeeAssignment(Manager manager, Employee employee){
        Objects.requireNonNull(manager);
        manager.getDisconnectedFrom(employee);
        employee.getDisconnectedFrom(manager);
    }

    public void transferToNewPosition(Employee employee, int salary){
        Objects.requireNonNull(employee);
        Employee transferredEmployee = new Employee(employee.getPerson(),
                LocalDate.now(), salary);
        remove(employee);
        try{
            addEmployee(transferredEmployee);
        }
        catch (EmployeeAlreadyExistsException e){
            throw new Error("Multiple instances of single employee in DB");
        }
    }

    public void transferToNewPosition(Employee employee, int salary,
                                      ArrayList<Employee> managerAssignedEmployees){
        Objects.requireNonNull(employee);
        Manager transferredEmployee = new Manager(employee.getPerson(),
                LocalDate.now(), salary, managerAssignedEmployees);
        remove(employee);
        try{
            addEmployee(transferredEmployee);
        }
        catch (EmployeeAlreadyExistsException e){
            throw new Error("Multiple instances of single employee in DB");
        }
    }

    public void transferToNewPosition(Employee employee, int salary,
                                      String jobDescription){
        Objects.requireNonNull(employee);
        OtherEmployee transferredEmployee = new OtherEmployee(employee.getPerson(),
                LocalDate.now(), salary, jobDescription);
        remove(employee);
        try{
            addEmployee(transferredEmployee);
        }
        catch (EmployeeAlreadyExistsException e){
            throw new Error("Multiple instances of single employee in DB");
        }
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
