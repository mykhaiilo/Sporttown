package com.sporttown.service;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Client;
import com.sporttown.domain.Data;
import com.sporttown.domain.Service;
import com.sporttown.domain.ServiceName;
import com.sporttown.domain.Sex;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    private double sum;

    private Bill bill;

    Client client = null;

    List<Service> list = null;

    private LocalDate happyDayFemale = Year.now().atMonth(Month.MARCH).atDay(8);

    private LocalDate happyDayMale = Year.now().atMonth(Month.OCTOBER).atDay(14);

    private LocalDate tnow = LocalDate.now();

    private void sum(Client client, List<Service> list) {

        for (int i = 0; i < list.size(); i++) {

            if (tnow == happyDayFemale
                    && client.getSex().equals(Sex.FEMALE.toString())
                    && list.equals(ServiceName.GYMFORONETIME)
                    && list.size() == 1) {
                list.get(i).setPrice(0);
            }
            if (tnow == happyDayMale
                    && client.getSex().equals(Sex.MALE.toString())
                    && list.equals(ServiceName.GYMFORONETIME)
                    && list.size() == 1) {
                list.get(i).setPrice(0);
            }
            if (client.getIsProffecional().equals("YES")
                    && list.size() == 1) {
                switch (list.get(i).getNames()) {
                    case SAYNA:
                        System.out.println("Price before discount = " + list.get(i).getPrice());
                        list.get(i).setPrice(0);
                        break;
                    case SLIPPERS:
                        list.get(i).setPrice(0);
                        break;
                    case MASSAGE:
                        list.get(i).setPrice(0);
                        break;
                    case TOWEL:
                        list.get(i).setPrice(0);
                        break;
                    default:
                        break;
                }
            }
            sum += list.get(i).getPrice();
            if ((tnow.getYear() - client.getDateOfEnter().getYear()) > 10) {
                sum *= 0.95;


            }
            bill.setSummaryPrice(sum);
        }
    }

    @Override
    public Bill buildBill(Data data) {

        client = data.getClient();
        list = data.getServices();
        bill = new Bill(client, list);
        list.size();
        sum(client, list);

        return bill;
    }


}

