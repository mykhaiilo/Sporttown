package com.sporttown.service;

import com.sporttown.domain.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;


/**
 * Created by admin on 30.01.2016.
 */
public class CalculatorServiceImpl implements CalculatorService {
    private double sum;
    private Bill bill = new Bill();
//    private UserDialogServiceImpl userDialogService = new UserDialogServiceImpl();
//    private Data data = userDialogService.getData();

//    public UserDialogServiceImpl getUserDialogService() {
//        return userDialogService;
//    }

    public double getSum() {
        return sum;
    }

/*    public double sum() {
        for (int i = 0; i < userDialogService.getN(); i++) {
            System.err.println(data.getServices().get(i).getPrice());
            sum += data.getServices().get(i).getPrice();
        }
        return bill.getSummaryPrice();
    }*/

   public LocalDate happyDayFemale = Year.now().atMonth(Month.MARCH).atDay(8);
    public LocalDate happyDayMale = Year.now().atMonth(Month.OCTOBER).atDay(14);
    public LocalDate tnow = LocalDate.now();

    public void discount(Client client, List<Service> list) {
        if ((tnow.getYear() - client.getDateOfEnter().getYear()) > 10) {
            sum *= 0.95;
        }
        if (client.getIsProffecional() == true
                && (list.equals(ServiceName.SAYNA))
                    || list.equals(ServiceName.SLIPPERS)
                    || list.equals(ServiceName.MASSAGE)
                    || list.equals(ServiceName.TOWEL)) {
            sum = 0;
        }
        if (tnow == happyDayFemale
                && client.getSex().equals(Sex.FEMALE.toString())
                && list.equals(ServiceName.GYMFORONETIME)) {
            sum = 0;
            System.out.println("Happy women day");
        }
        if (tnow == happyDayMale
                && client.getSex().equals(Sex.MALE.toString())
                && list.equals(ServiceName.GYMFORONETIME)) {
            sum = 0;
            System.out.println("Happy men day");

        }
    }

    @Override
    public Bill buildBill(Data data) {

        Client client = data.getClient();
        List<Service> list = data.getServices();
        discount(client, list);

        //bill.getListOfServices();
        //bill.setSummaryPrice(sum);

        return bill;
    }
}
