package org.java.training.autumn.salary.calculator;

import org.java.training.autumn.employee.IPayee;

import java.util.ArrayList;
import java.util.HashMap;

public interface SalaryCalculator {
    public HashMap<IPayee,Integer> distributeAdditionalFunds(
            ArrayList<IPayee> subjectsToPay, int funds);
}
