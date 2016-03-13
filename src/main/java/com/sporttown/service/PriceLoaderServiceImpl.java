package com.sporttown.service;

import com.sporttown.domain.Data;
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
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("Bundle", locale);
    private Map<String, String> serviceMap = new HashMap<>();

    public Map<String, String> getServiceMap() {
        makePriceforServices();
        return serviceMap;

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
}
