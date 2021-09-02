package org.java.training.autumn.controller;

import java.util.ArrayList;
import java.util.HashMap;

public interface RegexContainer {

    // Cyrillic first name
    String REGEX_FIRST_NAME_UKR = "f";
    // Latin first name
    String REGEX_FIRST_NAME_LAT = "f";

    // Cyrillic second name
    String REGEX_SECOND_NAME_UKR = "s";
    // Latin second name
    String REGEX_SECOND_NAME_LAT = "s";

    // login
    String REGEX_LOGIN = "[A-Za-z0-9_\\-]{8,20}";

    // home phone number
    String REGEX_HOME_PHONE = "";
    // cell phone number
    String REGEX_CELL_PHONE = "";

    // mail
    String REGEX_MAIL = "";
    // skype name https://support.skype.com/en-us/faq/FA94/What-is-a-Skype-Name
    String REGEX_SKYPE = "[a-zA-Z][a-zA-Z0-9_\\-\\,\\.]{5,31}";

}
