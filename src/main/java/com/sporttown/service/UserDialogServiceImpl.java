package com.sporttown.service;

import com.sporttown.domain.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 03.02.2016.
 */
public class UserDialogServiceImpl implements UserDialogService {

    private Data data = new Data();
    private Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
    private String readerText;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private boolean regexName(String s) {
        Pattern pattern = Pattern.compile("[a-zA-z ]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private void Name() {
        System.out.println("Please enter your name");
        for (int i = 3; i >0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexName(readerText)) {
                clientBuilder = clientBuilder.makeNameSurname(readerText);
                return;
            } else {

                System.err.println("Please enter letters from 'a' to 'z' " + (i-1) + " tries left ");
                if (i == 1) {
                    System.exit(0);
                }

            }

        }

    }

    private void Town() {
        System.out.println("Please enter your town");
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexName(readerText)) {
                clientBuilder = clientBuilder.makeTown(readerText);
                return;
            } else {
                                System.err.println("Please enter letters from 'a' to 'z'" + (i-1) + " tries left ");
                if (i == 1) {
                    System.exit(0);
                }

            }

        }
    }

    private boolean regexDateOfBirth(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(LocalDate.parse(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (IllegalArgumentException e) {
        } catch (DateTimeParseException e) {

        }
        return false;
    }

    private void DateOfBirth() throws IOException {
        for (int i = 3; i >0; i--) {
            try {
                System.out.println("Please enter the date of birth : Year-month-day");
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfBirth(LocalDate.parse(readerText));
                return;
            } else {
                System.err.println("You have " + (i-1) + " tries left ");
                if (i == 1) {
                    System.exit(0);
                }
            }
        }

    }

    private void DateOfEnter() throws IOException {
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println("Please enter the date of enter : Year-month-day");
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfEnter(LocalDate.parse(readerText));
                return;
            } else {
                System.err.println("You have " + (i-1) + " tries left ");
                if (i == 1) {
                    System.exit(0);
                }
            }
        }

    }

    private boolean regexSex(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(Sex.valueOf(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (IllegalArgumentException e) {
        }
        return false;
    }

    private void SexCount() {
        System.out.println("Please enter your Sex");
        for (int i = 0; i < 3; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                System.err.println("EXCEPTION");
                e.printStackTrace();
            }
            if (regexSex(readerText)) {
                clientBuilder = clientBuilder.makeSex(Sex.valueOf(readerText));
                return;
            } else {
                                System.err.println("Please enter 'MALE' or 'FEMALE '" + (i-1) + " tries left ");
                if (i == 1) {
                    System.exit(0);
                }
            }

        }
    }

    private boolean regexLevel(String s) {
        Pattern pattern = Pattern.compile("([Y,y](es|ES|eS|Es))|([N,n](o|O))");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private boolean regexLevel2(String s) {
        Pattern pattern = Pattern.compile("([Y,y](es|ES|eS|Es))");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private void levelCount() {
        System.out.println("Please answer are you professional sportsmen 'YES' or 'NO' " );
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexLevel(readerText)) {
                clientBuilder = clientBuilder.makeLevel(readerText);
                return;
            } else {

                System.err.println("Please enter 'YES/yes' or 'NO/no'" + (i-1) + " tries left ");
                if (i == 1) {
                    System.exit(0);
                }

            }

        }

    }

    private Client buildClient() {

        try {


            Name();

            Town();

            DateOfBirth();

            DateOfEnter();

            SexCount();

            levelCount();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientBuilder.build();
    }

    private List<Service> buildServices() {

        Service.ServiceBuilder serviceBuilder = new Service.ServiceBuilder();

        try {

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
                    buildCount();


        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("You din't follow instruction");
            System.exit(0);
        }
        return data.getServices();
    }

    private void buildCount(){
        System.out.println("Do you want more service ?");
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexLevel2(readerText)) {
                buildServices();

            } else {
          return;

            }

        }


    }

    @Override
    public Data readData() {
        data.setClient(buildClient());
        data.setServices(buildServices());
        return data;
    }

}


