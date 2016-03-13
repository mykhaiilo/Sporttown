package com.sporttown.service;

import com.sporttown.domain.Bill;
import com.sporttown.domain.Client;
import com.sporttown.domain.Data;
import com.sporttown.domain.Service;
import com.sporttown.domain.ServiceName;
import com.sporttown.domain.Sex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);
    private double sum;
    private Bill bill;
    private Client client;
    private List<Service> list;
    private LocalDate tnow;
    private static final LocalDate internationalWomenDay = Year.now().atMonth(Month.MARCH).atDay(8);
    private static final LocalDate dayOfDefender = Year.now().atMonth(Month.OCTOBER).atDay(14);
    private ResourceService resourceService = new ResourceService();

    private void sum(Client client, List<Service> list) {

        for (int i = 0; i < list.size(); i++) {
            try {
                if (tnow == internationalWomenDay
                        && Sex.FEMALE.toString().equals(client.getSex())
                        && list.equals(ServiceName.GYMFORONETIME)
                        && list.size() == 1) {
                    list.get(i).setPrice(0);
                    System.out.println(resourceService.labels.getString("s24"));
                }
                 if (tnow == dayOfDefender
                        && Sex.MALE.toString().equals(client.getSex())
                        && list.equals(ServiceName.GYMFORONETIME)
                        && list.size() == 1) {
                    list.get(i).setPrice(0);
                    System.out.println(resourceService.labels.getString("s25"));
                }
                 if (client.getIsProffecional() == true
                        && list.size() == 1) {
                    switch (list.get(i).getNames()) {
                        case SAYNA:
                            list.get(i).setPrice(0);
                            System.out.println(resourceService.labels.getString("s26"));
                            break;
                        case SLIPPERS:
                            list.get(i).setPrice(0);
                            System.out.println(resourceService.labels.getString("s27"));
                            break;
                        case MASSAGE:
                            list.get(i).setPrice(0);
                            System.out.println(resourceService.labels.getString("s28"));
                            break;
                        case TOWEL:
                            list.get(i).setPrice(0);
                            System.out.println(resourceService.labels.getString("s29"));
                            break;
                        default:
                            break;
                    }
                }
                sum += list.get(i).getPrice();
                if ((tnow.getYear() - client.getDateOfEnter().getYear()) > 10) {
                    sum *= 0.95;
                    System.out.println(resourceService.labels.getString("s30"));
                }
                bill.setSummaryPrice(Math.round(sum));
            } catch (NullPointerException e) {
                logger.error(resourceService.labels.getString("s31"));
                e.printStackTrace();
            }
        }
    }

    public Bill buildBill(Data data) {

        client = data.getClient();
        list = data.getServices();
        tnow = data.getTnow();
        bill = new Bill(client, list);
        sum(client, list);
        return bill;
    }


}

