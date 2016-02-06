package com.sporttown.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 03.02.2016.
 */
public class Bill {

    private double summaryPrice;

    private List<Service> listOfServices = new ArrayList<>();

    private Client client;

    public List<Service> getListOfServices(){
        return listOfServices;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        System.out.println("Client " + client.toString());
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
