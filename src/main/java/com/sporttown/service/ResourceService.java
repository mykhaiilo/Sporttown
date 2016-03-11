package com.sporttown.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceService {

    public Locale locale = new Locale("en", "US");
    public ResourceBundle labels = ResourceBundle.getBundle("ResourceBundle", locale);

    public void LocationsLanguage() {
        if (System.getProperties().getProperty("user.language").equals("ua")) {
            locale = new Locale("ua", "UA");
            labels = ResourceBundle.getBundle("ResourceBundle", locale);
        }
    }


}
