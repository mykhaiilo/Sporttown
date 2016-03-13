package com.sporttown.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;

    public class Client {
    private String nameSurname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnter;
    private String town;
    private Sex sex;
    private boolean isProffecional;


    public LocalDate getDateOfEnter() {
        return dateOfEnter;
    }

    public Sex getSex() {
        return sex;
    }

    public boolean getIsProffecional() {
        return isProffecional;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }

    public static class ClientBuilder {
        private String nameSurname;
        private LocalDate dateOfBirth;
        private LocalDate dateOfEnter;
        private String town;
        private Sex sex;
        private boolean level;
        private static int count;



        public ClientBuilder makeNameSurname(String name_surname) {
            this.nameSurname = name_surname;
            count++;
            return this;
        }

        public ClientBuilder makeDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public ClientBuilder makeDateOfEnter(LocalDate dateOfEnter) {
            this.dateOfEnter = dateOfEnter;
            return this;
        }

        public ClientBuilder makeTown(String town) {
            this.town = town;
            return this;
        }

        public ClientBuilder makeSex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public ClientBuilder makeLevel(boolean level) {
            this.level = level;
            return this;
        }

        public Client build() {
            Client client = new Client();
            client.nameSurname=nameSurname;
            client.dateOfBirth=dateOfBirth;
            client.dateOfEnter=dateOfEnter;
            client.town=town;
            client.sex=sex;
            client.isProffecional=level;

            return client;

        }
    }

}
