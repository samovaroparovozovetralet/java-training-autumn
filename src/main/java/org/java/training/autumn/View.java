package org.java.training.autumn;

public class View {
    public static final byte LINE_LENGTH = 40;
    public static final char SEPARATOR_CHAR = '#';

    public static final String HELP_MESSAGE = "Possible commands: \"end\", \"custom\", \"casual\".";
    public static final String ERR_MESSAGE = "Wrong input";
    public static final String CASUAL_MESSAGE = "Enter number between 0 and 100";
    public static final String CUSTOM_MESSAGE = "You successfully changed range";
    public static final String END_GAME_MESSAGE = "Thank you for playing, Gamer!";

    public static final String CUSTOM_RANGE_MIN_MESSAGE = "Enter min random number value:";
    public static final String CUSTOM_RANGE_MAX_MESSAGE = "Enter max random number value:";
    public static final String OUT_OF_RANGE_MESSAGE = "Number out of range";
    public static final String BAD_INPUT_RANGE_MESSAGE = "Can`t generate a number in that range.";

    public final String separationLine = buildSeparationLine();
    private final MainMenu mainMenu;

    public View(){
        this.mainMenu = new MainMenu();
    }

    public void printMessage(String message){
        System.out.println(fitMessageToLine(message));
    }

    public void displayRange(int min, int max){
        printMessage("Current range: from " + min + " to " + max);
    }

    public void displayMenu(){
        System.out.println(mainMenu);
    }

    public void displayStatistic(Statistics statistics){
        printMessage("Your entered number " + statistics.getCurrentNumber());
        printMessage("Total attempts: " + statistics.getTotalAttempts());
        printMessage("Successful attempts: " + statistics.getSuccessfulAttempts());
        printMessage("Accuracy: " + statistics.getAccuracy());
    }

    public String buildSeparationLine(){
        StringBuilder sb = new StringBuilder();
        for (int i = LINE_LENGTH-1; i>=0; i--){
            sb.append(SEPARATOR_CHAR);
        }
        sb.append("\n");
        return sb.toString();
    }

    public String whitespaceLine(){
        StringBuilder sb = new StringBuilder();
        for (int i=LINE_LENGTH-1; i>=0; i--){
            sb.append(" ");
        }
        return sb.toString();
    }

    public String whitespaceLine(int lineLength){
        StringBuilder sb = new StringBuilder();
        for (int i=lineLength-1; i>=0; i--){
            sb.append(" ");
        }
        return sb.toString();
    }

    public String fitMessageToLine(String str) {
        String[] words = str.split("\\s+");
        StringBuilder fullTextBuilder = new StringBuilder();
        StringBuilder lineBuilder = new StringBuilder();

        for (String word : words){
            if (lineBuilder.length() + word.length() < LINE_LENGTH){
                lineBuilder.append(" ");
                lineBuilder.append(word);
            }
            else{
                lineBuilder.append("\n");
                fullTextBuilder.append(lineBuilder.toString());
                lineBuilder = new StringBuilder(word);
            }
        }
        if(lineBuilder.length() !=0) {
            fullTextBuilder.append(lineBuilder.toString());
        }

        return fullTextBuilder.toString();
    }

    public String centerMessage(String str){
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        if (str.length()>LINE_LENGTH){
            return fitMessageToLine(str);
        }
        else {
            int lengthDiff = LINE_LENGTH - str.length();
            sb.append(whitespaceLine(lengthDiff / 2));
            sb.append(str);
        }
        return sb.toString();
    }

    public class MainMenu {

        public static final String WELCOME_MESSAGE = "Hello Gamer";
        public static final String USER_GUIDE = "Some guide";



        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(separationLine);
            sb.append(centerMessage(WELCOME_MESSAGE));
            sb.append("\n");
            sb.append(fitMessageToLine(USER_GUIDE));
            sb.append("\n");
            sb.append(separationLine);


            return sb.toString();
        }
    }
}
