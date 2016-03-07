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
    private final String yesNo= "([Y,y](es|ES|eS|Es))|([N,n](o|O))";

    private boolean checkregexName(String s) {
        Pattern pattern = Pattern.compile("[a-zA-z ]*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private void createName() {

        System.out.println(resourceService.labels.getString("s1"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);

            }
            if (checkregexName(readerText)) {
                clientBuilder = clientBuilder.makeNameSurname(readerText);
                return;
            } else {
                System.out.println(resourceService.labels.getString("s16") + " " + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));


                }

            }

        }

    }

    private void createTown() {
        System.out.println(resourceService.labels.getString("s2"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);

            }
            if (checkregexName(readerText)) {
                clientBuilder = clientBuilder.makeTown(readerText);
                return;
            } else {
                System.out.println(resourceService.labels.getString("s16") + " " + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                    logger.info(resourceService.labels.getString("s18"));
                }

            }

        }
    }

    private boolean checkregexDateOfBirth(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(LocalDate.parse(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (DateTimeParseException e) {
            logger.error(resourceService.labels.getString("s20"), e);
        } catch (IllegalArgumentException e) {
            logger.error(resourceService.labels.getString("s15"), e);
        }
        return false;
    }

    private void createDateOfBirth() throws IOException {
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println(resourceService.labels.getString("s3"));
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);

            } catch (DateTimeParseException e) {
                logger.error(resourceService.labels.getString("s20"), e);
            }

            if (checkregexDateOfBirth(readerText)) {
                clientBuilder = clientBuilder.makeDateOfBirth(LocalDate.parse(readerText));
                return;
            } else {
                System.out.println(resourceService.labels.getString("s19") + " " + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));

                }
            }
        }

    }

    private boolean checkregexDateOfEnter(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(LocalDate.parse(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (DateTimeParseException e) {
            logger.error(resourceService.labels.getString("s20"), e);
        } catch (IllegalArgumentException e) {
            logger.error(resourceService.labels.getString("s15"), e);
        }
        return false;
    }

    private void createDateOfEnter() throws IOException {
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println(resourceService.labels.getString("s4"));
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);

            }
            if (checkregexDateOfEnter(readerText)) {
                clientBuilder = clientBuilder.makeDateOfEnter(LocalDate.parse(readerText));
                return;
            } else {
                System.out.println(resourceService.labels.getString("s19") + " " + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));

                }
            }
        }

    }

    private boolean checkregexSex(String s) {
        try {
            Pattern pattern = Pattern.compile(String.valueOf(Sex.valueOf(s)));
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        } catch (IllegalArgumentException e) {
            logger.error(resourceService.labels.getString("s21"));
        }
        return false;
    }

    private void createMaleFemale() {
        System.out.println(resourceService.labels.getString("s5"));
        for (int i = 0; i < 3; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);

            }
            if (checkregexSex(readerText)) {
                clientBuilder = clientBuilder.makeSex(Sex.valueOf(readerText));
                return;
            } else {
                System.out.println(resourceService.labels.getString("s22") + " " + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));

                }
            }

        }
    }

    private boolean checkregexLevel(String s) {
        Pattern pattern = Pattern.compile(yesNo);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private boolean checkregexCount(String s) {
        Pattern pattern = Pattern.compile(yesNo);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private void createlevelCount() {
        System.out.println(resourceService.labels.getString("s6"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                logger.error(resourceService.labels.getString("s15"), e);

            }
            if (checkregexLevel(readerText)) {
                clientBuilder = clientBuilder.makeLevel(readerText);
                return;
            } else {
                System.out.println(resourceService.labels.getString("s21") + " " + (i - 1));
                if (i == 1) {
                    System.out.println(resourceService.labels.getString("s17"));
                }

            }

        }

    }

    private Client createClient() {

        try {

            createName();
            createTown();
            createDateOfBirth();
            createDateOfEnter();
            createMaleFemale();
            createlevelCount();

        } catch (IOException e) {
            logger.error(resourceService.labels.getString("s15"), e);

        }
        return clientBuilder.build();
    }

    private List<Service> createServices() {

        Service.ServiceBuilder serviceBuilder = new Service.ServiceBuilder();

        try {
            System.out.println(resourceService.labels.getString("s7"));
            ServiceName[] serviceNames = ServiceName.values();
            for (ServiceName serviceName : serviceNames) {
                System.out.print(serviceName.toString() + ", ");
            }
            System.out.println();
            readerText = reader.readLine();
            serviceBuilder = serviceBuilder.makeName(ServiceName.valueOf(readerText)).makePrice();
            System.out.println(resourceService.labels.getString("s8"));
            readerText = reader.readLine();
            serviceBuilder = serviceBuilder.makeAmount(Integer.parseInt(readerText));
            data.getServices().add(serviceBuilder.build());
            createCount();


        } catch (IOException e) {
            System.out.println(resourceService.labels.getString("s15"));

        } catch (Exception e) {
            System.out.println(resourceService.labels.getString("s17"));
        }
        return data.getServices();
    }

    private void createCount() {
        System.out.println(resourceService.labels.getString("s9"));
        for (int i = 3; i > 0; i--) {
            try {
                readerText = reader.readLine();
            } catch (IOException e) {
                System.out.println(resourceService.labels.getString("s15"));
            }
            if (checkregexCount(readerText)) {
                createServices();

            } else {
                return;
            }

        }


    }

    public Data readData() {
        resourceService.LocationsLanguage();
        data.setClient(createClient());
        data.addAllServices(createServices());
        return data;
    }

}


