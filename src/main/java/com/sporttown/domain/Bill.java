package com.sporttown.domain;

import com.sporttown.service.UserDialogServiceImpl;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Created by admin on 03.02.2016.
 */
public class Bill extends UserDialogServiceImpl{




    private double summaryPrice;

    public double getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(double summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    private List<Service> listOfServices =null;

    private Client client =null;

    public Client getClient() {
        return client;
    }

    public List<Service> getListOfServices(){
        return listOfServices;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
       /* System.out.println("Client " + client.);
        System.out.println("With all discounts you need to pay  " + summaryPrice);
        System.out.println("Thank you for being our costumer, good luck");
        StringBuilder sb = new StringBuilder();
        for (Service s: listOfServices) {
            sb.append(s.toString());
        }
        sb.append(LocalDate.now());
        return sb.toString();*/
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}

