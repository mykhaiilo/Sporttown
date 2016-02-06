package com.sporttown.domain;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by admin on 15.01.2016.
 */
    public class Client {
    private String nameSurname;
    private LocalDate dateOfBirth;
    private LocalDate dateOfEnter;
    private String town;
    private String sex;
    private String level;
    private int count = 0;

    public LocalDate getDateOfEnter() {
        return dateOfEnter;
    }

    public String getSex() {
        return sex;
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

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }

    public static class ClientBuilder {
        private String nameSurname;
        private LocalDate dateOfBirth;
        private LocalDate dateOfEnter;
        private String town;
        private String sex;
        private String level;
        private static int count;

        public LocalDate getDateOfEnter() {
            return dateOfEnter;
        }

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

        public ClientBuilder makeSex(String sex) {
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
            client.setLevel(level);
            client.setCount(count);
            return client;

        }
    }

}
