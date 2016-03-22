package com.sporttown.service;

import com.sporttown.domain.Data;
import com.sporttown.domain.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class PriceLoaderServiceImpl implements PriceLoaderService {
    private static final Logger logger = LoggerFactory.getLogger(PriceLoaderService.class);
    private static final String csvFile = "./src/main/resources/ServicePrices.csv";
    private static final String csvSplitBy = ",";
        private String line = "";
    private Data data = new Data();
    private Locale locale = data.getLocale();
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourceBundle", locale);
    private Map<String, String> serviceMap = new HashMap<>();

    public void setServiceMap(Service service) {
        makePriceforService(service);

    }

    private void makePriceforServices() {
        BufferedReader priceReader = null;
        try {
            priceReader = new BufferedReader(new FileReader(csvFile));
            while ((line = priceReader.readLine()) != null) {
                String[] price = line.split(csvSplitBy);
                serviceMap.put(price[0], price[1]);
            }
        } catch (FileNotFoundException e) {
            serviceMap = null;
            logger.error(resourceBundle.getString("s23") + e);
        } catch (IOException e) {
            logger.error(resourceBundle.getString("s11") + e);
        } finally {
            if (priceReader != null) {
                try {
                    priceReader.close();
                } catch (IOException e) {
                    logger.error(resourceBundle.getString("s11") + e);
                }
            }
        }
    }

    public void makePriceforService(Service service) {
        String csvFile = "./src/main/resources/ServicePrices.csv";
        String line = "";
        String csvSplitBy = ",";
        BufferedReader priceReader = null;
        int priceForService;
        try

        {
            priceReader = new BufferedReader(new FileReader(csvFile));

            while ((line = priceReader.readLine()) != null) {
                String[] price = line.split(csvSplitBy);
                serviceMap.put(price[0], price[1]);
            }
            switch (service.getNames()) {
                case GYMFORONETIME:
                    priceForService = Integer.parseInt(serviceMap.get("GYMFORONETIME"));
                    service.setPrice(priceForService);
                    break;
                case GYMTO4PM12:
                    priceForService = Integer.parseInt(serviceMap.get("GYMTO4PM12"));
                    service.setPrice(priceForService);
                    break;
                case GYMALLDAY12:
                    priceForService = Integer.parseInt(serviceMap.get("GYMALLDAY12"));
                    service.setPrice(priceForService);
                    break;
                case GYMTO4PMMONTH:
                    priceForService = Integer.parseInt(serviceMap.get("GYMTO4PMMONTH"));
                    service.setPrice(priceForService);
                    break;
                case GYMALLMONTH31:
                    priceForService = Integer.parseInt(serviceMap.get("GYMALLMONTH31"));
                    service.setPrice(priceForService);
                    break;
                case GYMTRAINER12:
                    priceForService = Integer.parseInt(serviceMap.get("GYMTRAINER12"));
                    service.setPrice(priceForService);
                    break;
                case MASSAGE:
                    priceForService = Integer.parseInt(serviceMap.get("MASSAGE"));
                    service.setPrice(priceForService);
                    break;
                case SAYNA:
                    priceForService = Integer.parseInt(serviceMap.get("SAYNA"));
                    service.setPrice(priceForService);
                    break;
                case SOLARIY:
                    priceForService = Integer.parseInt(serviceMap.get("SOLARIY"));
                    service.setPrice(priceForService);
                    break;
                case KROSFIT:
                    priceForService = Integer.parseInt(serviceMap.get("KROSFIT"));
                    service.setPrice(priceForService);
                    break;
                case YOGA:
                    priceForService = Integer.parseInt(serviceMap.get("YOGA"));
                    service.setPrice(priceForService);
                    break;
                case TOWEL:
                    priceForService = Integer.parseInt(serviceMap.get("TOWEL"));
                    service.setPrice(priceForService);
                    break;
                case SLIPPERS:
                    priceForService = Integer.parseInt(serviceMap.get("SLIPPERS"));
                    service.setPrice(priceForService);
                    break;
                case FRESH:
                    priceForService = Integer.parseInt(serviceMap.get("FRESH"));
                    service.setPrice(priceForService);
                    break;
                default:
                    logger.error("This is incorrect service name, " +
                            "please check it again.");
                    break;
            }
        } catch (FileNotFoundException e) {
            logger.error("resourceService.labels.getString(\"s23\")");
            switch (service.getNames()) {
                case GYMFORONETIME:
                    priceForService = 35;
                    service.setPrice(priceForService);
                    break;
                case GYMTO4PM12:
                    priceForService = 390;
                    service.setPrice(priceForService);
                    break;
                case GYMALLDAY12:
                    priceForService = 420;
                    service.setPrice(priceForService);
                    break;
                case GYMTO4PMMONTH:
                    priceForService = 450;
                    service.setPrice(priceForService);
                    break;
                case GYMALLMONTH31:
                    priceForService = 490;
                    service.setPrice(priceForService);
                    break;
                case GYMTRAINER12:
                    priceForService = 800;
                    service.setPrice(priceForService);
                    break;
                case MASSAGE:
                    priceForService = 200;
                    service.setPrice(priceForService);
                    break;
                case SAYNA:
                    priceForService = 150;
                    service.setPrice(priceForService);
                                        break;
                case SOLARIY:
                    priceForService = 30;
                    service.setPrice(priceForService);
                    break;
                case KROSFIT:
                    priceForService = 35;
                    service.setPrice(priceForService);
                    break;
                case YOGA:
                    priceForService = 150;
                    service.setPrice(priceForService);
                    break;
                case TOWEL:
                    priceForService = 5;
                    service.setPrice(priceForService);
                    break;
                case SLIPPERS:
                    priceForService = 5;
                    service.setPrice(priceForService);

                    break;
                case FRESH:
                    priceForService = 50;
                    service.setPrice(priceForService);
                    break;
            }
        } catch (IOException e) {
            logger.error("resourceService.labels.getString(\"s11\")");
        } finally {
            if (priceReader != null) {
                try {
                    priceReader.close();
                } catch (IOException e) {
                    logger.error(resourceBundle.getString("s11") + e);
                }
            }
        }

    }
}
