package com.sporttown.service;

import com.sporttown.domain.Client;
import com.sporttown.domain.Data;
import com.sporttown.domain.Service;
import com.sporttown.domain.ServiceName;
import com.sporttown.domain.Sex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDialogServiceImpl implements UserDialogService {

    private static final Logger logger = LoggerFactory.getLogger(UserDialogServiceImpl.class);
    private Data data = new Data();
    private Client.ClientBuilder clientBuilder = new Client.ClientBuilder();
    private String readerText;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

    private boolean regexName(String s) {
        Pattern pattern = Pattern.compile("[a-zA-z ]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private void Name() {
        System.out.println("Please enter your name");
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error("Please type in another format", e);
                e.printStackTrace();
            }
            if (regexName(readerText)) {
                clientBuilder = clientBuilder.makeNameSurname(readerText);
                return;
            } else {
                logger.info("Please enter letters from 'a' to 'z' " + (i - 1) + " tries left ");
                if(i==1){
                    System.out.println("You didn't follow instruction your name would be null");
                    logger.info("User didn't follow instruction Answered on question typed 3 times wrong");

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
                logger.error("Please type in another format", e);
                e.printStackTrace();
            }
            if (regexName(readerText)) {
                clientBuilder = clientBuilder.makeTown(readerText);
                return;
            } else {
                logger.info("Please enter letters from 'a' to 'z'" + (i - 1) + " tries left ");
                if (i == 1) {
                    System.out.println("You didn't follow instruction your town would be null");
                    logger.info("User didn't follow instruction Answered on question typed 3 times wrong");
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
            logger.error("Please type in another format", e);
        } catch (DateTimeParseException e) {
            logger.error("Incorrect data type format", e);
        }
        return false;
    }

    private void DateOfBirth() throws IOException {
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println("Please enter the date of birth : Year-month-day");
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error("Please type in another format", e);
                e.printStackTrace();
            }
            if (regexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfBirth(LocalDate.parse(readerText));
                return;
            } else {
                logger.info("You have " + (i - 1) + " tries left ");
                if (i == 1) {
                    System.out.println("You didn't follow instruction your date of birth would be null");
                    logger.info("User didn't follow instruction Answered on question typed 3 times wrong");
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
                logger.error("Please type in another format", e);
                e.printStackTrace();
            }
            if (regexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfEnter(LocalDate.parse(readerText));
                return;
            } else {
                logger.info("You have " + (i - 1) + " tries left ");
                if (i == 1) {
                    System.out.println("You didn't follow instruction your DateofENterGYm would be null");
                    logger.info("User didn't follow instruction Answered on question typed 3 times wrong");
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
            logger.error("Please type correct value YES or NO");
        }
        return false;
    }

    private void countMaleFemale() {
        System.out.println("Please enter your Sex");
        /*System.out.println(ResourceBundle.getBundle("please_enter_sex"));*/
        // please_enter_sex=Please enter your Sex
        for (int i = 0; i < 3; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error("Please type in another format", e);
                e.printStackTrace();
            }
            if (regexSex(readerText)) {
                clientBuilder = clientBuilder.makeSex(Sex.valueOf(readerText));
                return;
            } else {
                logger.info("Please enter 'MALE' or 'FEMALE '" + (i - 1) + " tries left ");
                if (i == 1) {
                    System.out.println("You didn't follow instruction your SEX would be null");
                    logger.info("User didn't follow instruction Answered on question typed 3 times wrong");
                }
            }

        }
    }

    private boolean regexLevel(String s) {
        Pattern pattern = Pattern.compile("([Y,y](es|ES|eS|Es))|([N,n](o|O))");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private boolean regexCount(String s) {
        Pattern pattern = Pattern.compile("([Y,y](es|ES|eS|Es))");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private void levelCount() {
        System.out.println("Please answer are you professional sportsmen 'YES' or 'NO' ");
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error("Please type in another format", e);
                e.printStackTrace();
            }
            if (regexLevel(readerText)) {
                clientBuilder = clientBuilder.makeLevel(readerText);
                return;
            } else {
                logger.info("Please enter 'YES' or 'NO'" + (i - 1) + " tries left ");
                if (i == 1) {
                    System.out.println("You didn't follow instruction Answered on question would be null");
                    logger.info("User didn't follow instruction Answered on question typed 3 times wrong");
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
            countMaleFemale();
            levelCount();

        } catch (IOException e) {
            logger.error("Please type in another format", e);
            e.printStackTrace();
        }
        return clientBuilder.build();
    }

    private List<Service> buildServices() {

        Service.ServiceBuilder serviceBuilder = new Service.ServiceBuilder();

        try {

            System.out.println("GYMFORONETIME, GYMTO4PM12, GYMALLDAY12, GYMTO4PMMONTH, GYMALLMONTH31, GYMTRAINER12, MASSAGE, YOGA, SAYNA, KROSFIT, SOLARIY, TOWEL, SLIPPERS, FRESH");
            readerText = reader.readLine();
            serviceBuilder = serviceBuilder.makeName(ServiceName.valueOf(readerText)).makePrice();
            System.out.println("Please enter amount ");
            try {
                readerText = reader.readLine();
                serviceBuilder = serviceBuilder.makeAmount(Integer.parseInt(readerText));

            } catch (Exception e) {
                logger.info("Please type number");
                System.exit(0);
            }

            data.getServices().add(serviceBuilder.build());
            buildCount();


        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Please type in another format");

        } catch (Exception e) {
            logger.info("You din't follow instruction");
            System.exit(0);
        }
        return data.getServices();
    }

    private void buildCount() {
        System.out.println("Do you want more service ?");
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error("Please type in another format", e);
            }
            if (regexCount(readerText)) {
                buildServices();

            } else {
                return;
            }

        }


    }

    public Data readData() {
        data.setClient(buildClient());
        data.setServices(buildServices());
        return data;
    }

}


