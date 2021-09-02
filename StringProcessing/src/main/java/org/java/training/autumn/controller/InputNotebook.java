package org.java.training.autumn.controller;

import org.java.training.autumn.view.View;

import java.util.*;

import static org.java.training.autumn.controller.MapBuilder.buildLanguageRegexMap;
import static org.java.training.autumn.controller.RegexContainer.REGEX_LOGIN;
import static org.java.training.autumn.view.TextConstants.*;

public class InputNotebook {
    public static final HashMap<String, HashMap<String,String>> languageRegexMap = buildLanguageRegexMap();

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
        this.firstName = utilityController.inputStringValueWithScanner(FIRST_NAME_DATA,
                languageRegexMap.get(View.language).get(FIRST_NAME));

        this.secondName = utilityController.inputStringValueWithScanner(SECOND_NAME_DATA,
                languageRegexMap.get(View.language).get(SECOND_NAME));

        this.login = utilityController.inputStringValueWithScanner(LOGIN_DATA, REGEX_LOGIN);
    }


}
