package org.java.training.autumn;

public class View {

    public static final String USER_GUIDE = "Hello gamer, try to figure out secret number";
    public static final String ERR_MESSAGE = "Input is not an int number";
    public static final String END_GAME_MESSAGE = "Thank you for playing, Gamer!";

    public static final String YOUR_WAY = "Your way: ";
    public static final String TOTAL_ATTEMPTS = "Total attempts: ";
    public static final String SUCCESSFUL_ATTEMPTS = "Successful attempts: ";
    public static final String ACCURACY = "Accuracy: ";
    public static final String CURRENT_RANGE = "Current range:";
    public static final String FROM = "from";
    public static final String TO = "to";
    public static final String WHITE_SPACE = " ";

    public static final String OUT_OF_RANGE_MESSAGE = "Number out of range";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void displayRange(int min, int max){
        printMessage(concatenationString(CURRENT_RANGE, WHITE_SPACE, FROM,
                WHITE_SPACE + min + WHITE_SPACE, TO, WHITE_SPACE + max));
    }

    public void displayMenu(){
        printMessage(USER_GUIDE);
    }

    public void displayStatistic(Statistics statistics){
        printMessage(concatenationString(YOUR_WAY, statistics.getHistory().toString()));
        printMessage(TOTAL_ATTEMPTS + statistics.getTotalAttempts());
        printMessage(SUCCESSFUL_ATTEMPTS + statistics.getSuccessfulAttempts());
        printMessage(ACCURACY + statistics.getAccuracy());
    }

    public String concatenationString (String... message){
        StringBuilder concatString = new StringBuilder();
        for (String v : message){
            concatString.append(v);
        }
        return new String(concatString);
    }

}
