package org.java.training.autumn.controller;

import org.java.training.autumn.view.View;

import java.util.Date;
import java.util.Scanner;

import static org.java.training.autumn.controller.RegexContainer.REGEX_LOGIN;
import static org.java.training.autumn.view.TextConstants.LOGIN_DATA;

public class InputNotebook {
    private View view;
    private Scanner sc;


    private String firstName;
    private String secondName;

    private String login;
    private String homePhone;
    private String cellPhone;

    private String email;
    private String skype;

    private String address;

    private Date createdAt;

    public InputNotebook(View view, Scanner sc){
        this.view = view;
        this.sc = sc;
    }

    public void getNote(){
        UtilityController utilityController = new UtilityController(view, sc);

        this.login = utilityController.inputStringValueWithScanner(LOGIN_DATA, REGEX_LOGIN);
    }


}
