package com.sporttown.service;

import com.sporttown.domain.Client;
import com.sporttown.domain.Data;
import com.sporttown.domain.Service;
import com.sporttown.domain.ServiceName;

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

    private int n;

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int getN() {
        return n;
    }

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

            System.out.println("Please answer the question:'Are you professional sportsmen: YES/NO' ");
            clientBuilder = clientBuilder.makeLevel(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientBuilder.build();
    }

    private List<Service> buildServices() {

        Service.ServiceBuilder serviceBuilder = new Service.ServiceBuilder();

        System.out.println("Please choose hove many services do you want have ");

        try {
            n = Integer.parseInt(reader.readLine());
            if (n > 0) {
                for (int j = 0; j < n; j++) {
                    System.out.println("GYMFORONETIME, GYMTO4PM12, GYMALLDAY12, GYMTO4PMMONTH, GYMALLMONTH31, GYMTRAINER12, MASSAGE, YOGA, SAYNA, KROSFIT, SOLARIY, TOWEL, SLIPPERS, FRESH");
                    serviceBuilder = serviceBuilder.makeName(ServiceName.valueOf(reader.readLine())).makePrice();
                    System.out.println("Please enter amount ");

                    try {
                        serviceBuilder = serviceBuilder.makeAmount(Integer.parseInt(reader.readLine()));

                    } catch (Exception e) {
                        System.err.println("Please type number");
                        System.exit(0);
                    }

                    data.getServices().add(serviceBuilder.build());

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
        return data.getServices();
    }

    @Override
    public Data readData() {
        data.setClient(buildClient());
        data.setServices(buildServices());
        return data;
    }
}
