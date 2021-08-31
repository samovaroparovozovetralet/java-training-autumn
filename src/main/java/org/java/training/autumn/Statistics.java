package org.java.training.autumn;

public class Statistics {
    private int currentNumber;
    private int previousNumber;
    private int successfulAttempts;
    private int totalAttempts;
    private double accuracy;

    public Statistics(){
        currentNumber = 0;
        previousNumber = 0;
        successfulAttempts=0;
        totalAttempts=0;
        accuracy=0.0;
    }

    public void attempt(int inputNumber, boolean attemptSuccess){
        previousNumber = currentNumber;
        currentNumber = inputNumber;
        if (attemptSuccess){successfulAttempts++;}
        totalAttempts++;
        accuracy = (double)successfulAttempts / totalAttempts;
    }

    public int getCurrentNumber(){
        return currentNumber;
    }

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
