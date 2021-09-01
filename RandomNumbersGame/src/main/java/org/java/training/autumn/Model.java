package org.java.training.autumn;

import java.util.Random;

public class Model {
    public static final int DEFAULT_MIN = 0;
    public static final int DEFAULT_MAX = 100;

    private int min;
    private int max;
    private final Random myRandom;
    private int randomNumber;
    private final Statistics statistics;
    private boolean modelState;

    public Model(){
        setRange(DEFAULT_MIN, DEFAULT_MAX);
        modelState = true;
        myRandom = new Random();
        setNewRandomNumber();
        statistics = new Statistics();
    }

    public void setNewRandomNumber(){
        if(modelState){
            randomNumber = myRandom.nextInt(max-min-1) + min + 1;
        }
    }

    public int getRandomNumber(){
        return randomNumber;
    }

    public void setRange(int min, int max){
        this.min = min;
        this.max = max;
        if(min >= max){
            modelState = false;
        }
    }

    public void setSeed(int seed){
        myRandom.setSeed(seed);
        setNewRandomNumber();
    }

    public boolean checkState(){
        return modelState;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }

    public Statistics getStatistics(){
        return statistics;
    }

    public boolean checkInRange(int inputNumber){
        if(inputNumber>min && inputNumber < max){return true;}
        return false;
    }

    public boolean checkEquals(int inputNumber){
        if(!checkInRange(inputNumber)){return false;}

        if(this.randomNumber>inputNumber){
            setRange(inputNumber, max);
        }
        else if(this.randomNumber<inputNumber){
            setRange(min, inputNumber);
        }
        else if(this.randomNumber==inputNumber){
            statistics.attempt(inputNumber, true);
            return true;
        }
        statistics.attempt(inputNumber, false);
        return false;
    }
}
