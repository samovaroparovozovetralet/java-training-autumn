package org.java.training.autumn;

public class View {

    public static final String USER_GUIDE = "Hello gamer";
    public static final String HELP_MESSAGE = "Possible commands: \"end\", \"custom\", \"casual\".";
    public static final String ERR_MESSAGE = "Wrong input";
    public static final String CASUAL_MESSAGE = "Enter number between 0 and 100";
    public static final String CUSTOM_MESSAGE = "You successfully changed range";
    public static final String END_GAME_MESSAGE = "Thank you for playing, Gamer!";

    public static final String CUSTOM_RANGE_MIN_MESSAGE = "Enter min random number value:";
    public static final String CUSTOM_RANGE_MAX_MESSAGE = "Enter max random number value:";
    public static final String OUT_OF_RANGE_MESSAGE = "Number out of range";
    public static final String BAD_INPUT_RANGE_MESSAGE = "Can`t generate a number in that range.";


    public void printMessage(String message){
        System.out.println(message);
    }

    public void displayRange(int min, int max){
        printMessage("Current range: from " + min + " to " + max);
    }

    public void displayMenu(){
        printMessage(USER_GUIDE);
    }

    public void displayStatistic(Statistics statistics){
        printMessage("Your entered number " + statistics.getCurrentNumber());
        printMessage("Total attempts: " + statistics.getTotalAttempts());
        printMessage("Successful attempts: " + statistics.getSuccessfulAttempts());
        printMessage("Accuracy: " + statistics.getAccuracy());
    }

    public String concatenationString (String... message){
        StringBuilder concatString = new StringBuilder();
        for (String v : message){
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

}
