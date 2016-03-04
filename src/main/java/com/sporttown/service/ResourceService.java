package com.sporttown.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceService {
    public String lang = "en";
    public String country = "US";

    public void LocationsLanguage() {
        if (System.getProperties().getProperty("user.language").equals("en")) {
            lang = "ua";
            country = "UA";
        }
    }

    public Locale locale = new Locale(lang, country);
    public ResourceBundle labels = ResourceBundle.getBundle("ResourceBundle", locale);
}
