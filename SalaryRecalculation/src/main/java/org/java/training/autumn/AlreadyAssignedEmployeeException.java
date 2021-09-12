package org.java.training.autumn;

public class AlreadyAssignedEmployeeException extends Exception{
    private int employeeId;
    private int managerId;

    public AlreadyAssignedEmployeeException(String message,
                                            BasicEmployee employee, Manager manager){
        super(message);
        this.employeeId = employee.hashCode();
        this.managerId = manager.hashCode();
    }

    public AlreadyAssignedEmployeeException(String message, BasicEmployee employee){
        super(message);
        this.employeeId = employee.hashCode();
        this.managerId = employee.hashCode();
    }

    public int getEmployeeId(){return employeeId;}
    public int getManagerId(){return managerId;}
}
