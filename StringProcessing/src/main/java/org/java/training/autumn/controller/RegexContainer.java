package org.java.training.autumn.controller;

public interface RegexContainer {

    // Cyrillic name
    String REGEX_FIRST_NAME_UKR = "";
    // Latin name
    String REGEX_FIRST_NAME_LAT = "";
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
