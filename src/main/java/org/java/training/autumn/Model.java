package org.java.training.autumn;

import java.util.Random;

public class Model {
    public static final int DEFAULT_MIN = 0;
    public static final int DEFAULT_MAX = 100;

    private int min;
    private int max;
    private Random myRandom;
    private int randomNumber;
    private Statistics statistics;
    private boolean modelLogic;

    public Model(){
        min = DEFAULT_MIN;
        max = DEFAULT_MAX;
        modelLogic = true;
        myRandom = new Random();
        setNewRandomNumber();
        statistics = new Statistics();
    }

    public void setNewRandomNumber(){
        if(modelLogic){
            randomNumber = myRandom.nextInt(max-min) + min;
        }
    }

    public void setRange(int min, int max){
        this.min = min;
        this.max = max;
        if(min >= max){
            modelLogic = false;
        }
        else{ setNewRandomNumber(); }
    }

    public void setSeed(int seed){
        myRandom.setSeed(seed);
        setNewRandomNumber();
    }

    public boolean checkLogic(){
        return modelLogic;
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
        if(inputNumber>=min && inputNumber < max){return true;}
        return false;
    }

    public boolean checkEquals(int inputNumber){
        if(this.randomNumber==inputNumber){
            statistics.attempt(inputNumber, true);
            setNewRandomNumber();
            return true;
        }
        else {
            statistics.attempt(inputNumber, false);
        }
        return false;
    }
}
