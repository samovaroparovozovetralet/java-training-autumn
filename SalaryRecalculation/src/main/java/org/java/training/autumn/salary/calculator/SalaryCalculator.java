package org.java.training.autumn.salary.calculator;

import org.java.training.autumn.employee.CanBePaid;

import java.util.ArrayList;
import java.util.HashMap;

public interface SalaryCalculator {
    public HashMap<CanBePaid,Integer> distributeAdditionalFunds(
            ArrayList<CanBePaid> subjectsToPay, int funds);
}
