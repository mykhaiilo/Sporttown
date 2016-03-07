package com.sporttown.domain;

import com.sporttown.service.ResourceService;

import java.time.LocalDate;
import java.util.List;

public class Bill {

    private List<Service> listOfServices;

    private Client client;

    private double summaryPrice;

    public Bill(Client client, List<Service> services) {
        this.client = client;
        this.listOfServices = services;
    }

    public void setSummaryPrice(double summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public double getSummaryPrice() {
        return summaryPrice;
    }

    private ResourceService resourceService = new ResourceService();


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n"+resourceService.labels.getString("s10")+LocalDate.now());
        sb.append("\n" + client);
        for (Service s : listOfServices) {
            sb.append(s.toString());
        }
        sb.append("\n" + resourceService.labels.getString("s13") + " " + summaryPrice);
        sb.append("\n" + resourceService.labels.getString("s14"));

        return sb.toString();

    }

}

