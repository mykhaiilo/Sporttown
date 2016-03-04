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

    private ResourceService resourceService = new ResourceService();


    public String toString() {
        System.out.println(resourceService.labels.getString("s10")+ LocalDate.now());
        System.out.println(resourceService.labels.getString("s11") + client);
        System.out.println(resourceService.labels.getString("s12") + listOfServices);
        System.out.println(resourceService.labels.getString("s13") + summaryPrice);
        System.out.println(resourceService.labels.getString("s14"));


        StringBuilder sb = new StringBuilder();
        for (Service s : listOfServices) {
            sb.append(s.toString());
        }
        sb.append(LocalDate.now());
        return sb.toString();

    }

}

