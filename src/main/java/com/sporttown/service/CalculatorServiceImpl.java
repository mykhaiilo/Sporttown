package com.sporttown.service;

import com.sporttown.domain.Bill;

import com.sporttown.domain.Data;
import com.sporttown.domain.ServiceName;
import com.sporttown.domain.Sex;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;


/**
 * Created by admin on 30.01.2016.
 */
public class CalculatorServiceImpl implements CalculatorService {
    private double sum;
    private Bill bill = new Bill();
    private UserDialogServiceImpl userDialogService = new UserDialogServiceImpl();
    private Data data = userDialogService.getData();

    public UserDialogServiceImpl getUserDialogService() {
        return userDialogService;
    }

    public double getSum() {
        return sum;
    }

    public double sum() {
        for (int i = 0; i < userDialogService.getN(); i++) {
            System.err.println(data.getServices().get(i).getPrice());
            sum += data.getServices().get(i).getPrice();
        }
        return bill.getSummaryPrice();
    }

   public LocalDate happyDayFemale = Year.now().atMonth(Month.MARCH).atDay(8);
    public LocalDate happyDayMale = Year.now().atMonth(Month.OCTOBER).atDay(14);
    public LocalDate tnow = LocalDate.now();

    public void discount() {
        if ((tnow.getYear() - data.getClient().getDateOfEnter().getYear()) > 10) {
            sum *= 0.95;
        } else if (data.getClient().getLevel().equals("YES")
                && (data.getServices().equals(ServiceName.SAYNA))
                    || data.getServices().equals(ServiceName.SLIPPERS)
                    || data.getServices().equals(ServiceName.MASSAGE)
                    || data.getServices().equals(ServiceName.TOWEL)) {
            sum = 0;
        } else if (tnow == happyDayFemale
                && data.getClient().getSex().equals(Sex.FEMALE.toString())
                && data.getServices().equals(ServiceName.GYMFORONETIME)) {
            sum = 0;
            System.out.println("Happy women day");
        } else if (tnow == happyDayMale
                && data.getClient().getSex().equals(Sex.MALE.toString())
                && data.getServices().equals(ServiceName.GYMFORONETIME)) {
            sum = 0;
            System.out.println("Happy men day");

        }
    }

    @Override
    public Bill buildBill(Data data) {
        bill.getListOfServices();
        bill.setSummaryPrice(sum);

        return bill;
    }
}
