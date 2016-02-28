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
                logger.info("Discount for female date 8 March");
            }
            if (tnow == happyDayMale
                    && client.getSex().equals(Sex.MALE.toString())
                    && list.equals(ServiceName.GYMFORONETIME)
                    && list.size() == 1) {
                list.get(i).setPrice(0);
                logger.info("Discount for men day 14 October");
            }
            if (client.getIsProffecional().equals("YES")
                    && list.size() == 1) {
                switch (list.get(i).getNames()) {
                    case SAYNA:
                        list.get(i).setPrice(0);
                        logger.info("Professional sportsmen has discount for sayna");
                        break;
                    case SLIPPERS:
                        list.get(i).setPrice(0);
                        logger.info("Professional sportsmen has discount for slippers");
                        break;
                    case MASSAGE:
                        list.get(i).setPrice(0);
                        logger.info("Professional sportsmen has discount for massage");
                        break;
                    case TOWEL:
                        list.get(i).setPrice(0);
                        logger.info("Professional sportsmen has discount for towel");
                        break;
                    default:
                        break;
                }
            }
            sum += list.get(i).getPrice();
            if ((tnow.getYear() - client.getDateOfEnter().getYear()) > 10) {
                sum *= 0.95;
                logger.info("This client visit sport gym over then 10 years");


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

