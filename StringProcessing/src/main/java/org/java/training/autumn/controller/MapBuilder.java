package org.java.training.autumn.controller;

import java.util.HashMap;

import static org.java.training.autumn.controller.RegexContainer.*;
import static org.java.training.autumn.view.Languages.*;
import static org.java.training.autumn.view.TextConstants.*;

public class MapBuilder {

    public static HashMap<String, HashMap<String,String>> buildLanguageRegexMap(){
        HashMap<String, HashMap<String,String>> myMap = new HashMap<String, HashMap<String,String>>();

        HashMap<String,String> enRegexList = new HashMap<String,String>();
        enRegexList.put(FIRST_NAME,REGEX_FIRST_NAME_LAT);
        enRegexList.put(SECOND_NAME,REGEX_SECOND_NAME_LAT);
        myMap.put(ENGLISH, enRegexList);

        HashMap<String,String> uaRegexList = new HashMap<String,String>();
        uaRegexList.put(FIRST_NAME,REGEX_FIRST_NAME_UKR);
        uaRegexList.put(SECOND_NAME,REGEX_SECOND_NAME_UKR);
        myMap.put(UKRAINIAN, uaRegexList);

        return myMap;
    }
}
