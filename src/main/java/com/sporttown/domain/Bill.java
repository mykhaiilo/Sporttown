package com.sporttown.domain;

import java.time.LocalDate;
import java.util.List;

public class Bill {

    private List<Service> listOfServices;

    private Client client;

    private double summaryPrice;

    public Bill(Client client, List<Service> services){
        this.client= client;
        this.listOfServices=services;
    }

    public void setSummaryPrice(double summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public String toString() {
        System.out.println("Today is "+ LocalDate.now());
        System.out.println("Client " + client);
        System.out.println("Services "+ listOfServices);
        System.out.println("With all discounts you need to pay  " + summaryPrice);
        System.out.println("Thank you for being our costumer, good luck");

        StringBuilder sb = new StringBuilder();
        for (Service s: listOfServices) {
            sb.append(s.toString());
        }
        sb.append(LocalDate.now());
        return sb.toString();

    }

}

