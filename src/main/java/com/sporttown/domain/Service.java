package com.sporttown.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by admin on 03.02.2016.
 */
public class Service {

    private ServiceName names;
    private int price;

    public ServiceName getNames() {
        return names;
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

        ServiceName names;

        public void setNames(ServiceName names) {
            this.names = names;
        }

        public ServiceName getNames() {
            return names;
        }

        public int getPrice() {
            return price;
        }

        public ServiceBuilder makeName(ServiceName names) {
            this.names = names;
            return this;
        }

        public ServiceBuilder makeAmount(int amount) {
            this.amount = amount;
            price *= amount;

            return this;
        }


        public ServiceBuilder makePrice() {

            switch (names) {
                case GYMFORONETIME:
                    price = 35;
                    break;
                case GYMTO4PM12:
                    price = 390;
                    break;
                case GYMALLDAY12:
                    price = 420;
                    break;
                case GYMTO4PMMONTH:
                    price = 450;
                    break;
                case GYMALLMONTH31:
                    price = 490;
                    break;
                case GYMTRAINER12:
                    price = 800;
                    break;
                case MASSAGE:
                    price = 200;
                    break;
                case SAYNA:
                    price = 150;
                    break;
                case SOLARIY:
                    price = 150;
                    break;
                case KROSFIT:
                    price = 30;
                    break;
                case YOGA:
                    price = 35;
                    break;
                case TOWEL:
                    price = 5;
                    break;
                case SLIPPERS:
                    price = 5;
                    break;
                case FRESH:
                    price = 50;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid abonement" + names);
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
