package com.sporttown.service;

import com.sporttown.domain.Client;
import com.sporttown.domain.Data;
import com.sporttown.domain.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by admin on 03.02.2016.
 */
public class UserDialogServiceImpl implements UserDialogService {

    private Data data = new Data();

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private Client buildClient() {

        Client.ClientBuilder clientBuilder = new Client.ClientBuilder();

        try {

            System.out.println("Please enter your name");
            clientBuilder = clientBuilder.makeNameSurname(reader.readLine());

            System.out.println("Please enter town where you leave");
            clientBuilder = clientBuilder.makeTown(reader.readLine());

            System.out.println("Please enter your date of birth in format 1980-01-05");
            clientBuilder = clientBuilder.makeDateOfBirth(LocalDate.parse(reader.readLine()));

            System.out.println("Please enter your date when start visit gym format 2016-03-20");
            clientBuilder = clientBuilder.makeDateOfEnter(LocalDate.parse(reader.readLine()));

            System.out.println("Please enter your sex: MALE or FEMALE ");
            clientBuilder = clientBuilder.makeSex(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientBuilder.build();
    }

    private List<Service> buildServices(){
        return null;
    }

/**

    private void buildOneTimePayment() {
        System.out.println("Please choose hove many additional services do you want have ");
        int n = 0;
        try {
            n = Integer.parseInt(getReader().readLine());
            if (n > 0) {
                for (int j = 0; j < n; j++) {
                    OneTimePayment.OneTimePaymentBuilder oneTimePaymentBuilder = new OneTimePayment.OneTimePaymentBuilder();
                    System.out.println("Please chose service :MASSAGE, YOGA, SAYNA, KROSFIT,SOLARIY, TOWEL, SLIPPERS,FRESH");
                    oneTimePaymentBuilder = oneTimePaymentBuilder.makeName(NameOnePay.valueOf(getReader().readLine())).makePrice();
                    System.out.println("Please enter amount ");
                    try {
                        oneTimePaymentBuilder = oneTimePaymentBuilder.makeAmount(Integer.parseInt(getReader().readLine()));

                    } catch (Exception e) {
                        System.err.println("Please type number");
                        System.exit(0);
                    }

                    data.getOneTimePayments().add(oneTimePaymentBuilder.build());

                }
            } else {
                System.err.println("You didn't choose any additional service");
            }


        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("You din't follow instruction");
            System.exit(0);
        }


    }

    private void buildMultiplePayment() {
        System.out.println("Please choose hove many abonements you want to bye ");
        int n = 0;
        try {
            n = Integer.parseInt(getReader().readLine());
            if (n > 0) {
                for (int j = 0; j < n; j++) {
                    MultiplePayment.MultiplePaymentsBuilder multiplePaymentsBuilder = new MultiplePayment.MultiplePaymentsBuilder();
                    System.out.println("Please chose Abonenement :GYMFORONETIME,GYMTO4PM12,GYMALLDAY12,GYMTO4PMMONTH,GYMALLMONTH31,GYMTRAINER12 ");
                    multiplePaymentsBuilder = multiplePaymentsBuilder.makeName(ServiceName.valueOf(getReader().readLine())).makePrice();
                    System.out.println("Please enter amount ");
                    try {
                        multiplePaymentsBuilder = multiplePaymentsBuilder.makeAmount(Integer.parseInt(getReader().readLine()));
                    } catch (Exception e) {
                        System.err.println("Please type number");
                        System.exit(0);
                    }
                    data.getMultiplePayments().add(multiplePaymentsBuilder.build());

                }
            } else {
                System.err.println("You didn't choose any abonenment");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("You din't follow instruction");
            System.exit(0);
        }


    }

*/
   /* public void endPrice() {
        try {
            discount.money();
            System.out.println("Please answer the question are you professional sportsmen YES/NO?");
            String discount = reader.readLine();
            this.discount.setDiscount(discount);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


    @Override
    public Data readData() {
        data.setClient(buildClient());
        data.setServices(buildServices());
        return data;
    }
}
