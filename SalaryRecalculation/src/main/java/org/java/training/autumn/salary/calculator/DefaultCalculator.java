package org.java.training.autumn.salary.calculator;

import org.java.training.autumn.employee.IPayee;

import java.util.ArrayList;
import java.util.HashMap;

public class DefaultCalculator implements SalaryCalculator{
    public HashMap<IPayee,Integer> distributeAdditionalFunds(
            ArrayList<IPayee> subjectsToPay, int funds){

        return new HashMap<>();
    };
}
