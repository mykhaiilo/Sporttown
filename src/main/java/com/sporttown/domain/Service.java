package com.sporttown.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Service {

    private int amount;

    private ServiceName names;

    private int price;

    public ServiceName getNames() {
        return names;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(ServiceName names) {
        this.names = names;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static class ServiceBuilder {

        private int amount;
        private int price;
        private Map<String, String> maps = new HashMap<String, String>();
        private ServiceName names;

        public void setNames(ServiceName names) {
            this.names = names;
        }

        public ServiceName getNames() {
            return names;
        }

        public int getPrice() {
            return price;
        }

        public ServiceBuilder makeAmount(int amount) {
            this.amount = amount;

            return this;
        }

        public ServiceBuilder makeName(ServiceName names) {
            this.names = names;
            return this;
        }

        public ServiceBuilder makePrice() {
            String csvFile = "./src/main/resources/ServicePrices.csv";
            String line = "";
            String csvSplitBy = ",";
            BufferedReader priceReader = null;
            try

            {
                priceReader = new BufferedReader(new FileReader(csvFile));

                while ((line = priceReader.readLine()) != null) {
                    String[] price = line.split(csvSplitBy);
                    maps.put(price[0], price[1]);
                }
                switch (names) {
                    case GYMFORONETIME:
                        price = Integer.parseInt(maps.get("GYMFORONETIME"));
                        break;
                    case GYMTO4PM12:
                        price = Integer.parseInt(maps.get("GYMTO4PM12"));
                        break;
                    case GYMALLDAY12:
                        price = Integer.parseInt(maps.get("GYMALLDAY12"));
                        break;
                    case GYMTO4PMMONTH:
                        price = Integer.parseInt(maps.get("GYMTO4PMMONTH"));
                        break;
                    case GYMALLMONTH31:
                        price = Integer.parseInt(maps.get("GYMALLMONTH31"));
                        break;
                    case GYMTRAINER12:
                        price = Integer.parseInt(maps.get("GYMTRAINER12"));
                        break;
                    case MASSAGE:
                        price = Integer.parseInt(maps.get("MASSAGE"));
                        break;
                    case SAYNA:
                        price = Integer.parseInt(maps.get("SAYNA"));
                        break;
                    case SOLARIY:
                        price = Integer.parseInt(maps.get("SOLARIY"));
                        break;
                    case KROSFIT:
                        price = Integer.parseInt(maps.get("KROSFIT"));
                        break;
                    case YOGA:
                        price = Integer.parseInt(maps.get("YOGA"));
                        break;
                    case TOWEL:
                        price = Integer.parseInt(maps.get("TOWEL"));
                        break;
                    case SLIPPERS:
                        price = Integer.parseInt(maps.get("SLIPPERS"));
                        break;
                    case FRESH:
                        price = Integer.parseInt(maps.get("FRESH"));
                        break;
                    default:
                        System.err.println("This is incorrect service name, " +
                                "please check it again.");
                        System.exit(0);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return this;
        }


        public Service build() {
            Service service = new Service();
            service.setName(names);
            service.setPrice(price);
            return service;

        }


    }


}
