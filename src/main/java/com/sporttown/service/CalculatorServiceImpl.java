package com.sporttown.service;

import com.sporttown.domain.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    private double sum;
    private Bill bill = new Bill();
    Client client = null;
    List<Service> list = null;

    public Client getClient() {
        return client;
    }

    public List<Service> getList() {
        return list;
    }

    UserDialogServiceImpl userDialogService = new UserDialogServiceImpl();

    public void sum() {

        for (int i = 0; i < userDialogService.getCount(); i++) {
            sum += list.get(i).getPrice();
        }
         bill.setSummaryPrice(sum);
    }

    private LocalDate happyDayFemale = Year.now().atMonth(Month.MARCH).atDay(8);
    private LocalDate happyDayMale = Year.now().atMonth(Month.OCTOBER).atDay(14);
    private LocalDate tnow = LocalDate.now();

    public void setTnow(LocalDate tnow) {
        this.tnow = tnow;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void discount(Client client, List<Service> list) {
        try{
        if ((tnow.getYear() - client.getDateOfEnter().getYear()) > 10) {
            sum *= 0.95;
        }
        if (client.getIsProffecional().equals("YES")
                && (list.equals(ServiceName.SAYNA))
                    || list.equals(ServiceName.SLIPPERS)
                    || list.equals(ServiceName.MASSAGE)
                    || list.equals(ServiceName.TOWEL)
                && userDialogService.getCount() == 1) {
            sum = 0;
        }
        if (tnow == happyDayFemale
                && client.getSex().equals(Sex.FEMALE.toString())
                && list.equals(ServiceName.GYMFORONETIME)
                && userDialogService.getCount() == 1) {
            sum = 0;
            System.out.println("Happy women day");
        }
        if (tnow == happyDayMale
                && client.getSex().equals(Sex.MALE.toString())
                && list.equals(ServiceName.GYMFORONETIME)
                && userDialogService.getCount() == 1) {
            sum = 0;
            System.out.println("Happy men day");
        }
        } catch (NullPointerException e){}
    }

    @Override
    public Bill buildBill(Data data) {

        client = data.getClient();
        list = data.getServices();
        sum();
        discount(client, list);

        return bill;
    }

    public double getSum() {
        return sum;
    }
}
