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
    private ResourceService resourceService = new ResourceService();


    private boolean regexName(String s) {
        Pattern pattern = Pattern.compile("[a-zA-z ]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private void Name() {

        System.out.println(resourceService.labels.getString("s1"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);
                e.printStackTrace();
            }
            if (regexName(readerText)) {
                clientBuilder = clientBuilder.makeNameSurname(readerText);
                return;
            } else {
                logger.info(resourceService.labels.getString("s16") + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                    logger.info(resourceService.labels.getString("s18") + (i - 1));

                }

            }

        }

    }

    private void Town() {
        System.out.println(resourceService.labels.getString("s2"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);
                e.printStackTrace();
            }
            if (regexName(readerText)) {
                clientBuilder = clientBuilder.makeTown(readerText);
                return;
            } else {
                logger.info(resourceService.labels.getString("s16") + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                    logger.info(resourceService.labels.getString("s18"));
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
            logger.error(resourceService.labels.getString("s15"), e);
        } catch (DateTimeParseException e) {
            logger.error(resourceService.labels.getString("s20"), e);
        }
        return false;
    }

    private void DateOfBirth() throws IOException {
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println(resourceService.labels.getString("s3"));
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);
                e.printStackTrace();
            }
            if (regexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfBirth(LocalDate.parse(readerText));
                return;
            } else {
                logger.info(resourceService.labels.getString("s19") + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                    logger.info(resourceService.labels.getString("s18"));
                }
            }
        }

    }

    private void DateOfEnter() throws IOException {
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println(resourceService.labels.getString("s4"));
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);
                e.printStackTrace();
            }
            if (regexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfEnter(LocalDate.parse(readerText));
                return;
            } else {
                logger.info(resourceService.labels.getString("s19") + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                    logger.info(resourceService.labels.getString("s18"));
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
            logger.error(resourceService.labels.getString("s21"));
        }
        return false;
    }

    private void countMaleFemale() {
        System.out.println(resourceService.labels.getString("s5"));
        for (int i = 0; i < 3; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);
                e.printStackTrace();
            }
            if (regexSex(readerText)) {
                clientBuilder = clientBuilder.makeSex(Sex.valueOf(readerText));
                return;
            } else {
                logger.info(resourceService.labels.getString("s22") + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                    logger.info(resourceService.labels.getString("s18"));
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
        System.out.println(resourceService.labels.getString("s6"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);
                e.printStackTrace();
            }
            if (regexLevel(readerText)) {
                clientBuilder = clientBuilder.makeLevel(readerText);
                return;
            } else {
                logger.info(resourceService.labels.getString("s21") + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                    logger.info(resourceService.labels.getString("s18"));
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
            logger.error(resourceService.labels.getString("s15"), e);
            e.printStackTrace();
        }
        return clientBuilder.build();
    }

    private List<Service> buildServices() {

        Service.ServiceBuilder serviceBuilder = new Service.ServiceBuilder();

        try {
            System.out.println(resourceService.labels.getString("s7"));
            System.out.println("GYMFORONETIME, GYMTO4PM12, GYMALLDAY12, GYMTO4PMMONTH, GYMALLMONTH31, GYMTRAINER12, MASSAGE, YOGA, SAYNA, KROSFIT, SOLARIY, TOWEL, SLIPPERS, FRESH");
            readerText = reader.readLine();
            serviceBuilder = serviceBuilder.makeName(ServiceName.valueOf(readerText)).makePrice();
            System.out.println(resourceService.labels.getString("s8"));
            try {
                readerText = reader.readLine();
                serviceBuilder = serviceBuilder.makeAmount(Integer.parseInt(readerText));

            } catch (Exception e) {
                logger.info(resourceService.labels.getString("s23"));
                System.out.println(resourceService.labels.getString("s17"));
            }

            data.getServices().add(serviceBuilder.build());
            buildCount();


        } catch (IOException e) {
            e.printStackTrace();
            logger.info(resourceService.labels.getString("s15"));

        } catch (Exception e) {
            logger.info(resourceService.labels.getString("s17"));
            System.out.println(resourceService.labels.getString("s17"));
        }
        return data.getServices();
    }

    private void buildCount() {
        System.out.println(resourceService.labels.getString("s9"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);
            }
            if (regexCount(readerText)) {
                buildServices();

            } else {
                return;
            }

        }


    }

    public Data readData() {
        resourceService.LocationsLanguage();
        data.setClient(buildClient());
        data.setServices(buildServices());
        return data;
    }

}


