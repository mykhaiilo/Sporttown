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
    private String isProffecional;


    public LocalDate getDateOfEnter() {
        return dateOfEnter;
    }

    public Sex getSex() {
        return sex;
    }

    public String getIsProffecional() {
        return isProffecional;
    }

    public void setNameSurname(String namesurname) {
        this.nameSurname = namesurname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfEnter(LocalDate dateOfEnter) {
        this.dateOfEnter = dateOfEnter;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setIsProffecional(String isProffecional) {
        this.isProffecional = isProffecional;
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
        private String level;
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

        public ClientBuilder makeLevel(String level) {
            this.level = level;
            return this;
        }

        public Client build() {
            Client client = new Client();
            client.setNameSurname(nameSurname);
            client.setDateOfBirth(dateOfBirth);
            client.setDateOfEnter(dateOfEnter);
            client.setTown(town);
            client.setSex(sex);
            client.setIsProffecional(level);

            return client;

        }
    }

}
