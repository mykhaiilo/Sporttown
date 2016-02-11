package com.sporttown.domain;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 15.01.2016.
 */
public class Data {

    private List<Service> services = new ArrayList<>();

    private Client client = new Client();

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getServices() {
        return services;
    }


}


