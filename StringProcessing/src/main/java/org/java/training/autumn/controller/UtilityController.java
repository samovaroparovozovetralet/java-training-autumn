package org.java.training.autumn.controller;

import org.java.training.autumn.view.View;

import java.util.Scanner;

public class UtilityController {
    private View view;
    private Scanner sc;

    public UtilityController(View view, Scanner sc){
        this.view = view;
        this.sc = sc;
    }

    String inputStringValueWithScanner(String message, String regex){
        String res;
        view.printStringInput(message);
        while(!(sc.hasNext() && (res = sc.next()).matches(regex))){
            view.printWrongStringInput(message);
        }
        return res;
    }
}
