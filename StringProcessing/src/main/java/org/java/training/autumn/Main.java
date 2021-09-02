package org.java.training.autumn;

import org.java.training.autumn.controller.Controller;
import org.java.training.autumn.model.Model;
import org.java.training.autumn.view.View;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 *
 */
public class Main {
    public static void main( String[] args ) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
