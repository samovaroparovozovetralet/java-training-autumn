package org.java.training.autumn.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.java.training.autumn.view.TextConstants.*;

public class View {
    public static final String language =
            // "ua"; // Ukrainian
            "en"; // English

    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(language));

    public void printMessage(String message){System.out.println(message);}

    public void printStringInput(String message){
        printMessage(concatString(bundle.getString(INPUT_DATA),
                bundle.getString(message)));
    }
    public void printWrongStringInput(){
        printMessage(bundle.getString(WRONG_INPUT_DATA));
    }

    public String concatString(String... message){
        StringBuilder sb = new StringBuilder();
        for (String w : message){
            sb.append(w);
            sb.append(" ");
        }
        return sb.toString();
    }
}
