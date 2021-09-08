package org.java.training.autumn.controller;

import org.java.training.autumn.model.Model;
import org.java.training.autumn.model.notebook.NotUniqueLoginException;
import org.java.training.autumn.model.notebook.NoteBook;
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
        InputNoteBook inputNoteBook = new InputNoteBook(view, sc);
        inputNoteBook.getNote();

        NoteBook noteBook = getNoteBook(inputNoteBook);
    }

    private NoteBook getNoteBook(InputNoteBook inputNoteBook){
        NoteBook noteBook = null;
        while(true){
            try{
                noteBook = new NoteBook(inputNoteBook.getFirstName(),
                        inputNoteBook.getLogin());
                break;
            }
            catch (NotUniqueLoginException e){
                e.printStackTrace();
                view.printMessage(view.concatString(View.NOT_UNIQUE_LOGIN, e.getLogin()));
                inputNoteBook.inputLogin();
            }
        }
        return noteBook;
    }

}
