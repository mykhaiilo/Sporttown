package com.sporttown.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Service> services = new ArrayList<>();

    private Client client = new Client();

    public void setClient(Client client) {
        this.client = client;
    }

    public void addAllServices(List<Service> list){
        services.addAll(list);
    }

    public Client getClient() {
        return client;
    }

    public List<Service> getServices() {
        return services;
    }

    public LocalDate tnow = LocalDate.now();

    public LocalDate getTnow() {
        return tnow;
    }

    public void setTnow(LocalDate tnow) {
        this.tnow = tnow;
    }

    public void addService(Service service) {
        this.services.add(service);
    }
}




