package org.java.training.autumn.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
                     new Locale("ua"));    //Ukrainian
                    // new Locale("en"));   //English

    public void printMessage(String message){System.out.println(message);}

    public void printStringInput(String message){}
    public void printWrongStringInput(String message){}
}
