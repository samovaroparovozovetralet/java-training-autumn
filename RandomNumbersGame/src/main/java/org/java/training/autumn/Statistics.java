package org.java.training.autumn;

import java.util.ArrayList;

public class Statistics {
    private ArrayList<Integer> history;
    private int successfulAttempts;
    private int totalAttempts;
    private double accuracy;

    public Statistics(){
        history = new ArrayList<>();
        successfulAttempts=0;
        totalAttempts=0;
        accuracy=0.0;
    }

    public void attempt(int inputNumber, boolean attemptSuccess){
        if (attemptSuccess){successfulAttempts++;}
        else{history.add(inputNumber);}
        totalAttempts++;
        accuracy = (double)successfulAttempts / totalAttempts;
    }

    public ArrayList<Integer> getHistory(){return history;}

    public int getTotalAttempts(){
        return totalAttempts;
    }

    public int getSuccessfulAttempts(){
        return successfulAttempts;
    }

    public double getAccuracy() {
        return accuracy;
    }
}
