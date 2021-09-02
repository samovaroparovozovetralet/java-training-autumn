package org.java.training.autumn.controller;

import org.java.training.autumn.model.Model;
import org.java.training.autumn.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        InputNotebook inputNotebook = new InputNotebook(view, sc);
        inputNotebook.getNote();
    }
}
