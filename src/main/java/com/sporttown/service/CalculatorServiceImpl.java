package com.sporttown.service;

import com.sporttown.domain.Bill;

import com.sporttown.domain.Data;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;


/**
 * Created by admin on 30.01.2016.
 */
public class CalculatorServiceImpl implements CalculatorService {

    private Bill bill = new Bill();

/*    public void makeOnetimePaymantCalculate(Data data) {
        for (int i = 0; i < OneTimePayment.OneTimePaymentBuilder.getCount(); i++) {
            double onetimepay = 0;

            onetimepay += data.getOneTimePayments().get(i).getPrice();
            data.setOneTimePrice(onetimepay);
        }
        for (OneTimePayment op : data.getOneTimePayments()) {
            System.out.println(op);
        }

    }

    public void makeMultiplePaymentCalcaulate(Data data) {
        for (int i = 0; i < MultiplePayment.MultiplePaymentsBuilder.getCount(); i++) {
            double multiplypay = 0;

            multiplypay += data.getMultiplePayments().get(i).getPrice();
            data.setMultipleTimePrice(multiplypay);
        }
        for (MultiplePayment mp : data.getMultiplePayments()) {
            System.out.println(mp);
        }

    }*/

    public LocalDate happyDayFemale = Year.now().atMonth(Month.MARCH).atDay(8);
    public LocalDate happyDayMale = Year.now().atMonth(Month.OCTOBER).atDay(14);
    public LocalDate tnow = LocalDate.now();

    /*public void setDiscount(String money) {

        if (money.equalsIgnoreCase("YES") && (OneTimePayment.OneTimePaymentBuilder.getCount() == 1)) {
            data.setOneTimePrice(0);

        } else if (money.equalsIgnoreCase("NO")) {
            data.setOneTimePrice(data.getOneTimePrice());
        }
    }

    public void money() {

        if ((tnow.getYear() - data.getClient().getDateOfEnter().getYear()) > 10) {
            double price = data.getMultipleTimePrice();
            price *= 0.95;
            data.setMultipleTimePrice(price);

        }

        if (tnow == happyDayFemale
                && data.getClient().getSex() == Sex.FEMALE.toString()
                && data.getMultiplePayments().get(0).getNames() == ServiceName.GYMFORONETIME) {
            data.setMultipleTimePrice(0);
            System.out.println("Happy women day");

        }

        if (tnow == happyDayMale
                && data.getClient().getSex() == Sex.FEMALE.toString()
                && data.getMultiplePayments().get(0).getNames() == ServiceName.GYMFORONETIME) {
            data.setOneTimePrice(0);
            System.out.println("Happy Men day");

        }
    }*/

    @Override
    public Bill buildBill(Data data) {

        return bill;
    }
}