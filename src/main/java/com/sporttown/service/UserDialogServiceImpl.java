package com.sporttown.service;

import com.sporttown.domain.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 03.02.2016.
 */
public class UserDialogServiceImpl implements UserDialogService {

    private Data data = new Data();
    private Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
    private int n;
    private int countTries = 3;
    private String readerText;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int getN() {
        return n;
    }

    public Data getData() {
        return data;
    }

    public boolean regexName(String s) {
        Pattern pattern = Pattern.compile("[a-zA-z ]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public int testNameCount() {
        System.out.println("Please enter your name");
        for (int i = 0; i < 3; i++) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexName(readerText)) {
                clientBuilder = clientBuilder.makeNameSurname(readerText);
                countTries = 3;
                return 1;
            } else {
                countTries--;
                System.err.println("Please enter letters from 'a' to 'z' " + countTries + " tries left ");
                if (countTries == 0) {
                    System.exit(0);
                }

            }

        }
        return 0;
    }

    public boolean regexTown(String s) {
        Pattern pattern = Pattern.compile("[a-zA-z ]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public int testTownCount() {
        System.out.println("Please enter your town");
        for (int i = 0; i < 3; i++) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexTown(readerText)) {
                clientBuilder = clientBuilder.makeTown(readerText);
                countTries = 3;
                return 1;
            } else {
                countTries--;
                System.err.println("Please enter letters from 'a' to 'z'" + countTries + " tries left ");
                if (countTries == 0) {
                    System.exit(0);
                }

            }

        }
        return 0;
    }

    public boolean regexDateOfBirth(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(LocalDate.parse(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (IllegalArgumentException e) {
        } catch (DateTimeParseException e) {

        }
        return false;
    }

    public LocalDate testDateOfBirth() throws IOException {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Please enter the date of birth : Year-month-day");
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfBirth(LocalDate.parse(readerText));
                countTries = 3;
                return null;
            } else {
                countTries--;
                System.err.println("You have " + countTries + " tries left ");
                if (countTries == 0) {
                    System.exit(0);
                }
            }
        }
        return null;
    }

    public boolean regexDateOfEnter(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(LocalDate.parse(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (IllegalArgumentException e) {
        } catch (DateTimeParseException e) {

        }
        return false;
    }

    public LocalDate testDateOfEnter() throws IOException {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Please enter the date of enter : Year-month-day");
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexDateOfEnter(readerText)) {
                clientBuilder = clientBuilder.makeDateOfEnter(LocalDate.parse(readerText));
                countTries = 3;
                return null;
            } else {
                countTries--;
                System.err.println("You have " + countTries + " tries left ");
                if (countTries == 0) {
                    System.exit(0);
                }
            }
        }
        return null;
    }

    public boolean regexSex(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(Sex.valueOf(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (IllegalArgumentException e) {
        }
        return false;
    }

    public int testSexCount() {
        System.out.println("Please enter your Sex");
        for (int i = 0; i < 3; i++) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                System.err.println("EXCEPTION");
                e.printStackTrace();
            }
            if (regexSex(readerText)) {
                clientBuilder = clientBuilder.makeSex(readerText);
                countTries = 3;
                return 1;
            } else {
                countTries--;
                System.err.println("Please enter 'MALE' or 'FEMALE '" + countTries + " tries left ");
                if (countTries == 0) {
                    System.exit(0);
                }
            }

        }
        return 0;
    }

    public boolean regexLevel(String s) {
        Pattern pattern = Pattern.compile("([Y,y](es|ES|eS|Es))|([N,n](o|O))");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public int testLevelCount() {
        System.out.println("Please answer are you professional sportsmen YES or NO");
        for (int i = 0; i < 3; i++) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (regexLevel(readerText)) {
                clientBuilder = clientBuilder.makeLevel(readerText);
                countTries = 3;
                return 1;
            } else {
                countTries--;
                System.err.println("Please enter 'YES/yes' or 'NO/no'" + countTries + " tries left ");
                if (countTries == 0) {
                    System.exit(0);
                }

            }

        }
        return 0;
    }

    private Client buildClient() {

        try {


            testNameCount();

            testTownCount();

            testDateOfBirth();

            testDateOfEnter();

            testSexCount();

            testLevelCount();

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


